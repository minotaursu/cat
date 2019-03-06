package com.minotaur.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/**
 * ********************************
 * Created by minotaur on 2019/3/4. *
 * ********************************
 */
public class RpcFramework {

    public static void export(final Object service, int port) throws IOException {
        Preconditions.checkArgument(service != null);
        Preconditions.checkArgument(port > 0 && port <= 65535);
        final ServerSocket server = new ServerSocket(port);
        while (true) {
            try {
                final Socket socket = server.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ObjectInputStream inputStream = null;
                        ObjectOutputStream outputStream = null;
                        try {
                            try {
                                inputStream = new ObjectInputStream(socket.getInputStream());
                                String methodName = inputStream.readUTF();
                                Class<?>[] parameterTypes = (Class<?>[]) inputStream.readObject();
                                Object[] arguments = (Object[]) inputStream.readObject();

                                Method method = service.getClass().getMethod(methodName, parameterTypes);
                                Object result = method.invoke(service, arguments);

                                outputStream = new ObjectOutputStream(socket.getOutputStream());
                                outputStream.writeObject(result);
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            } catch (NoSuchMethodException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            } finally {
                                if (outputStream != null) {
                                    outputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                socket.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> T refer(final Class<T> interfaceClass, String host, int port) {
        Preconditions.checkArgument(interfaceClass != null);
        Preconditions.checkArgument(!Strings.isNullOrEmpty(host));
        Preconditions.checkArgument(port > 0 && port <= 65535);
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[] { interfaceClass },
            new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    Socket socket = new Socket(host, port);
                    ObjectOutputStream outputStream = null;
                    ObjectInputStream inputStream = null;
                    try {
                        outputStream = new ObjectOutputStream(socket.getOutputStream());
                        outputStream.writeUTF(method.getName());
                        outputStream.writeObject(method.getParameterTypes());
                        outputStream.writeObject(args);

                        inputStream = new ObjectInputStream(socket.getInputStream());
                        return inputStream.readObject();
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    } finally {
                        outputStream.close();
                        inputStream.close();
                        socket.close();
                    }
                }
            });
    }

}
