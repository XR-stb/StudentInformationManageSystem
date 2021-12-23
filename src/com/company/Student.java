package com.company;

public class Student {
    public String name;
    public String id;
    public String phone;
    public String academy;//学院
    public String TheClass;//班级
    public Student(){
    }

    public Student(String name, String id){
        this.name = name;
        this.id   = id;
    }

    public Student( String id, String name, String phone, String academy, String TheClass) {
        this.name = name;
        this.id   = id;
        this.phone = phone;
        this.academy = academy;
        this.TheClass = TheClass;
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student person = (Student) o;

        if (!id.equals(person.id)) return false;
        return true;
    }
    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}

