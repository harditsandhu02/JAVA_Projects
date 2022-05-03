import java.lang.Math;
public class Loan {

        private int duration;
        private double rate;
        private double amount;
        private double monthlyPayment;

        public Loan(int duration, double rate, double amount){
                this.duration = duration;
                this.rate = rate;
                this.amount = amount;
        }
        public int getDuration(){
                return duration;
        }
        public double getRate(){
                return rate;
        }
        public double getAmound(){
                return amount;
        }
        public void setDuration(int duration){
                this.duration = duration;
        }
        public void setRate(double rate){
                this.rate = rate;
        }
        public void setAmount(double amount){
                this.amount = amount;
        }

        public double calculateMonthlyPayment(){
                double monthly = amount * ((rate/12.0) * Math.pow(1 + (rate/12),duration))/(Math.pow(Math.pow(1 + (rate/12.0),duration)-1));
                return monthly;
        }
        public boolean calculateTotalCost(boolean output){
                // We can find the interest charged each month by multiplying the current balance by the monthly interest rate (annual rate / 12).
                double interest = amount * (rate/12.0);
                int payment;
                double principal;
                
                if (output == true){
                        for (int i; i <= 12; i++){
                                payment = i;
                                
                        }
                }
        }

        
        
    
}
