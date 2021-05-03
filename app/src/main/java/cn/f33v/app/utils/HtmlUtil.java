package cn.f33v.app.utils;

public class HtmlUtil {
    private static String deleteTag(String source) {
        //删除转义字符
        source = source.replaceAll("$.{2,6}?;", "");
        //删除script标签
        source = source.replaceAll("<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>", "");
        //删除style标签
        source = source.replaceAll("<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>", "");
        return source;
    }

    public static String deleteArticleTag(String source) {
        //删除HTML和markdown标签
        source = source.replaceAll("!\\[\\]\\((.*?)\\)", "").replaceAll("<[^>]+>", "");
        return deleteTag(source);
    }

    public static String deleteCommentTag(String source) {
        //保留图片标签
        source = source.replaceAll("(?!<(img).*?>)<.*?>", "");
        return deleteTag(source);
    }
}
