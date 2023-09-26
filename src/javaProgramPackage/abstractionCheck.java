package javaProgramPackage;
abstract class Animal {
  abstract void makeSound();

  Animal()
  {
	  System.out.println("Animal constructor Class");
	  
  }
  
  public void eat() {
    System.out.println("I can eat.");
  }
}

class Dog extends Animal {
	Dog()
	  {
		  System.out.println("Dog constructor Class");
		  
	  }
	  
  // provide implementation of abstract method
  public void makeSound() {
    System.out.println("Bark bark");
  }
}

class SmallCat extends Animal {

	SmallCat()
	  {
		  super();
	  }
	
	  // provide implementation of abstract method
	  public void makeSound() {
	    System.out.println("Meavu Meavu");
	  }
	}

class Cat extends Animal {

	Cat()
	  {
		  System.out.println("Cat constructor Class");
	  }
	
	  // provide implementation of abstract method
	  public void makeSound() {
	    System.out.println("Meavu Meavu");
	  }
	}

class abstractionCheck {
  public static void main(String[] args) {

    // create an object of Dog class
    Dog d1 = new Dog();

   
    d1.makeSound();
    d1.eat();
    
    Cat c=new Cat();
    c.makeSound();
    d1.eat();
  }
}