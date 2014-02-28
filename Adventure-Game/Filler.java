/*Eric Grube
 * COP 3330 Section 001
 * Adventure Game Program
 * Filler Class
 * 11/7/13
 */

public class Filler extends Character {
        
		//make a filler at the initial location and call the parent here for location
        public Filler(Cave initialLocation) {                
                super(initialLocation);                
        }
        
        //Try to modify the cave at its location. Fillers fill pits in this case
        public boolean modifyCave(Cave location) {                
                if(location.isPit()){                        
                        location.makeOpen();
                        return true;                        
                }
                
                else {                        
                        return false;                        
                }                
        }
        
        //Make a string describing the fillers modification
        public String describeModification() {                
                String mod = new String("Cave was filled in.");
                return mod;                
        }
        //Make an override of the move method from the character class to see if the filler can actually move to the new location
        public boolean move(Cave to) {
                
                if(to.isBlocked()) {                        
                        return false;                        
                }
                
                else if(to.isPit()) {                        
                        this.modifyCave(to);
                        super.move(to);
                        return true;                        
                }
                
                else if(to.isOccupied()) {                        
                        return false;                        
                }                
                
                else if (to.isTeleport()) {                        
                        super.move(to);
                        return true;                        
                }
                
                else {                        
                        super.move(to);
                        return true;                        
                }
                
        }
        
        //Get the name of the character
        public String getName() {                
                String name = new String("Filler");
                return name;                
        }
}
