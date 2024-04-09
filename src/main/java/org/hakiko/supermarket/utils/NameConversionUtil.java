package org.hakiko.supermarket.utils;

public class NameConversionUtil {

    /**
     * 将小驼峰命名转换为下划线命名
     * @param camelCase 小驼峰命名的字符串
     * @return 下划线命名的字符串
     */
    public static String camelToUnderscore(String camelCase) {
        StringBuilder sb = new StringBuilder(camelCase);
        int temp = 0;//定位
        for (int i = 0; i < camelCase.length(); i++) {
            if (Character.isUpperCase(camelCase.charAt(i))) {
                sb.insert(i + temp, "_");
                temp += 1;
            }
        }
        return sb.toString().toLowerCase();
    }

    /**
     * 将下划线命名转换为小驼峰命名
     * @param underscore 下划线命名的字符串
     * @return 小驼峰命名的字符串
     */
    public static String underscoreToCamel(String underscore) {
        StringBuilder sb = new StringBuilder(underscore);
        int temp = 0;//定位
        for (int i = 0; i < underscore.length(); i++) {
            if (underscore.charAt(i) == '_') {
                int j = i + temp;
                sb.deleteCharAt(j);
                sb.replace(j, j + 1, String.valueOf(Character.toUpperCase(sb.charAt(j))));
                temp -= 1;
            }
        }
        return sb.toString();
    }
}