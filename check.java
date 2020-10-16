class check {
    public static void main(String args[] ) throws Exception {
        
    try{
        // System.out.println(Integer.parseInt("2147483648"));
    }catch(NumberFormatException exception){
        System.out.println(Integer.parseInt("2147483647"));
        System.out.println("eception");
    }

    System.out.println(0 % 5);
        

    }
}