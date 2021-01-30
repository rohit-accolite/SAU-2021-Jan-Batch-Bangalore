package question_three;

public class Class1 {

    Class2 class2;

    public Class1(Class2 class2) {
        this.class2= class2;
    }

    public String giveName(String name) {
        return name;
    }

    public int findMax(int num1, int num2) {
//        if(num1 > num2) return num1;
//        else return num2;
        return 0;
    }

    public String getLongerString(String s1,String s2) {
        return class2.findLongerString(s1, s2);
    }
}
