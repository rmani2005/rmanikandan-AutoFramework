package javaProgramPackage;


	class thiskeyword {
	
	    int age;
	    String age2;
	    thiskeyword(int age){
	        this.age = age;
	    }
	    thiskeyword(String age2){
	    	age2 = age2;
	    }
	
	    public static void main(String[] args) {
	    	thiskeyword obj = new thiskeyword(8);
	    	thiskeyword obj1 = new thiskeyword("test");
	        System.out.println("obj.age = " + obj.age);
	        System.out.println("obj.age = " + obj1.age2);
	    }
	}

