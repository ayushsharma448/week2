
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

class HelloWorld{
	private String message;
  // private int a;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
public HelloWorld() {
	
}
}

class EEmployee{
	private String name;
   private int id;
   EEmployee(int id, String name)
	{
		System.out.println("id="+id+" and name="+name);
		this.id=id;
		this.name=name;
	}
   
}
@Configuration
class HelloWorldConfig {
	/*
	 * @Bean public HelloWorld helloWorld(){ //System.out.println(""); return new
	 * HelloWorld(); }
	 */
	 @Bean 
	 @Scope("prototype")
	   public HelloWorld helloWorld(){
		   System.out.println("helloWorld");
	      return new HelloWorld();
	   }
	 
   @Bean 
   @Scope("prototype")
   public EEmployee employeeinstant(int id, String name){
	   System.out.println("employee instant");
      return new EEmployee(id,name);
   }
   
}

public class Test {  
    	public static void main(String[] args) {
    		   ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
    		   
    		   HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
    		   helloWorld.setMessage("Hello World!");
    		   System.out.println(helloWorld.getMessage());
    		   
    		   EEmployee ee = ctx.getBean( EEmployee.class,10,"ayush");
    		 //  HelloWorld helloWorld = ctx.getBean(HelloWorld.class,10);
    		   
    		}
          
}  
