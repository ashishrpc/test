package com.designPattern;

public class MyBuilder {
    private String id;
    private String name;
    private String age;
    private String nationality;
    private MyBuilder(MyBuilderFactory objMyBuilderFactory){
        this.id=objMyBuilderFactory.id;
        this.name=objMyBuilderFactory.name;
        this.age=objMyBuilderFactory.age;
        this.nationality=objMyBuilderFactory.nationality;
    }
    public String toString(){
        return "id:"+this.id+"; Name:"+this.name+"; Age:"+this.age+"; Nationality:"+this.nationality;
    }
    
    public static void main(String[] args) { 
        
        MyBuilder obj=new MyBuilder.MyBuilderFactory("101","Ashish").setAge("35").setNationality("Indian").build();
        System.out.println(obj.toString());
    }
    public static class MyBuilderFactory{
        private String id;
        private String name;
        private String age;
        private String nationality;
        public MyBuilderFactory(String id, String name){
            this.id=id;
            this.name=name;
        }
        public MyBuilderFactory setAge(String age){
            this.age=age;
            return this;
        }
        public MyBuilderFactory setNationality(String nationality){
            this.nationality=nationality;
            return this;
        }
        public MyBuilder build(){
            return new MyBuilder(this);
        }
        
    }
}
