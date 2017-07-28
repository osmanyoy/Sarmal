package com.training.spring;

public class BuilderPattern {
    private String name;
    private String tel;
    private int    length;

    private BuilderPattern() {
    }

    public String getName() {
        return name;
    }


    public String getTel() {
        return tel;
    }

    public int getLength() {
        return length;
    }

    public static BuilderPatternBuilder getBuilder() {
        return new BuilderPatternBuilder();
    }

    static public class BuilderPatternBuilder {
        private String name;
        private String tel;
        private int    length;

        private BuilderPatternBuilder() {

        }

        public String getName() {
            return name;
        }

        public BuilderPatternBuilder setName(String name) {
            this.name = name;
            return this;

        }

        public String getTel() {
            return tel;
        }

        public BuilderPatternBuilder setTel(String tel) {
            this.tel = tel;
            return this;
        }

        public int getLength() {
            return length;
        }

        public BuilderPatternBuilder setLength(int length) {
            this.length = length;
            return this;
        }

        public BuilderPattern build() {
            BuilderPattern builderPattern = new BuilderPattern();
            builderPattern.name = name;
            builderPattern.length = length;
            builderPattern.tel = tel;
            return builderPattern;
        }
    }

    public static void main(String[] args) {
        BuilderPattern builderPattern = BuilderPattern.getBuilder()
                                                      .setLength(100)
                                                      .setName("osman")
                                                      .setTel("733773")
                                                      .build();

    }
}