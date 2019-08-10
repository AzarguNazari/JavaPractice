package InnerClass;

/**
 *
 * @author codex
 */
public class Car {
    class Engine{
        private String engineName;
        public double weight;
        public Engine(String engineName, double weight){
            this.engineName = engineName;
            this.weight = weight;
        }
        public String getEngine(){return engineName;}
        public double getWeight(){return weight;}
        public void setEngine(String engineName){this.engineName = engineName;}
        public void setWeight(double weight){this.weight = weight;}
    }
    
    
    
}
