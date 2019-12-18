public class Regular_Employee extends Employee{  
private float salary;  
private int bonus;  
  

 public Regular_Employee() {}

   public Regular_Employee(float salary, int bonus) {
      this.salary = salary;
      this.bonus = bonus;
   }
   
   public float getSalary() {
      return salary;
   }
   
   public void setSalary( float salary ) {
      this.salary = salary;
   }
   
   public int getBonus() {
      return bonus;
   }
   
   public void setBonus( int bonus ) {
      this.bonus = bonus;
   }
   
}  