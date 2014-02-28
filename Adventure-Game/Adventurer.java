/*Eric Grube
 * COP 3330 Section 001
 * Adventure Game Program
 * Adventurer Class
 * 11/7/13
 */

public class Adventurer extends Character {
        
       //Put an adventurer at the initial location using the parent class
        public Adventurer(Cave initialLocation) {                
                super(initialLocation);                
        }
        
         //Try to modify the cave at its location
        public boolean modifyCave(Cave loc) {                
                if(loc.isTeleport()){                        
                        loc.setMarked(true);
                        return true;                        
                }
                
                else {                        
                        return false;                        
                }                
        }

        //Make a string that describes what changes were made by the adventurer to a cave
        public String describeModification() {                
                String mod = new String("Cave was marked.");
                return mod;                
        }
        
        //This overrides the move method from the character class and see if the adventurer can actually move to this new location
        public boolean move(Cave to) {                
                if(to.isBlocked()) {                        
                        return false;                        
                }
                
                else if(to.isTeleport()) {                        
                        this.modifyCave(to);
                        super.move(to);
                        return true;                        
                }
                
                else if(to.isOccupied()) {                        
                        return false;                        
                }                
          
                else {                        
                        super.move(to);
                        return true;                        
                }                
        }
        
        //This gets the name of the adventurer
        public String getName() {                
                String name = new String("Adventurer");
                return name;                
        }
}
