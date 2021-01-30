package question_three;

public class Class2 {

    Class1 class1;

    public Class2(Class1 class1) {
        this.class1= class1;
    }

    public String getName() {
       return class1.giveName("hello");
    }

    public int getMax(int num1, int num2) {
        return class1.findMax(num1, num2);
    }

    public String findLongerString(String s1, String s2) {
//        if(s1.length() > s2.length()) return s1;
//        else return s2;
        return "something";
    }
}
