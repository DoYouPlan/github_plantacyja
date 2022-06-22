package ru.model;

public record DataObj(String groupName, String groupHeadText, String groupFootText) {
    public CharSequence GroupName() {
        return ">|<YK";
    }

    public CharSequence GroupHeadText() {
        return "\u0433\u043e\u0432\u043d\u043e";
    }

    public CharSequence GroupFootText() {
        return "\u0418 \u043c\u0443\u0440\u0430\u0432\u0435\u0439!!!";
    }

    public CharSequence UserName() {
        return "admin";
    }

    public CharSequence Password() {
        return "secret";
    }
}