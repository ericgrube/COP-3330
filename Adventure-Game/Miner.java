/*Eric Grube
 * COP 3330 Section 001
 * Adventure Game Program
 * Miner Class
 * 11/7/13
 */

public class Miner extends Character {
        
        //Make a miner at the initial location using the parent constructor
        public Miner(Cave initialLocation) {                
                super(initialLocation);                
        }
        //Try to modify the cave. Miners unblock caves in this case
        public boolean modifyCave(Cave loc) {                
                if(loc.isBlocked()){                        
                        loc.makeOpen();
                        return true;                     
                }
                
                else {                        
                        return false;                        
                }                
        }
        
       //Make a string that says what the modification is
        public String describeModification() {                
                String mod = new String("Cave was unblocked.");
                return mod;                
        }
        //Need to override the move method from the character class to see if the miner can actually move to the new location
        public boolean move(Cave to) {
                
                if(to.isBlocked()){                        
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
        
        //Get the name of the miner
        public String getName() {                
                String name = new String("Miner");
                return name;                
        }

}
