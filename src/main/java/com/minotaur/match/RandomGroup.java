package com.minotaur.match;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ********************************
 * Created by minotaur on 2018/8/22. *
 * ********************************
 */
public class RandomGroup {

    public static void main(String[] args) {
        String[] names = { "邵杰", "梁欢", "王书培", "董磊", "骆彬彬", "陈钦辉", "张旭东", "胡辉", "张端", "赵朝峰", "冯佳勇", "董一强", "姚从海", "丁超",
                           "潘磊", "沈春", "唐海东", "冯利斌", "陈晨", "江湘舟", "王李坤", "温泉", "刘宇", "蒋帅", "黄四火", "何双", "包月星", "毛晨光",
                           "刘嘉威", "裴晨晨", "廖银", "方丹芳", "袁园", "周欣", "陈宇", "刘金晶", "杨杰", "屠丽文", "王阳" };
        List tmp = Arrays.asList(names);
        Collections.shuffle(tmp);
        names = (String[]) tmp.toArray();
        int members = 5;
        System.out.println(names.length);
        int groupNum = names.length / members + 1;
        System.out.println(groupNum);
        String[][] result = new String[groupNum][members];
        int j = -1;
        for (int i = 0; i < names.length; i++) {
            int pos = i % groupNum;
            if (pos == 0) {
                j++;
            }
            result[pos][j] = names[i];

        }
        for (int n = 0; n < groupNum; n++) {
            System.out.println("No:" + (n + 1));
            for (int m = 0; m < members; m++) {
                String name = result[n][m];
                if (name != null) {
                    System.out.print(result[n][m] + ",");
                }
            }
            System.out.println();
        }
    }
}
