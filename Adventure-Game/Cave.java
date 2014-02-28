/*Eric Grube
 * COP 3330 Section 001
 * Adventure Game Program
 * Cave Class
 * 11/7/13
 */

public class Cave extends Object {
               
		private int row;
        private int column;
        private boolean occupied;
        private boolean marked;
        private CaveType cave;
        
        //Make an enum of the different types that a cave can be
        public static enum CaveType {                
                PIT, TELEPORT, BLOCKED, OPEN
        }  
        
        //Make an open cave that starts unoccupied and unmarked
        public Cave(int row, int column) {
                this.row = row;
                this.column = column;
                occupied = false;
                marked = false;
                cave = CaveType.OPEN;
        }
        
        //return the rows 
        public int getRow() {
                return this.row;                
        }
        
        //return the columns
        public int getCol() {                
                return this.column;               
        }
        
        //set the cave as occupied or unoccupied
        public boolean isOccupied() {               
                return occupied;                
        }
        
        //set the occupied variable set for cave
        public void setOccupied(boolean set) {              
                this.occupied = set;               
        }
        
               
        //sets the cave as marked or not
        public void setMarked(boolean set) {               
                this.marked = set;                
        }
        
        //Get the marked value of the cave
        public boolean isMarked() {               
                return this.marked;               
        }
        
        //Mark the cave opened
        public void makeOpen() {                
                this.cave = CaveType.OPEN;                
        }
        
        //find out whether the cave is open or not
        public boolean isOpen() {                
                switch (this.cave) {                
                        case OPEN:                                
                                return true;                               
                        		default:                               
                                return false;               
                }               
        }
        
        //mark the cave as a blocked cave
        public void makeBlocked() {              
                this.cave = CaveType.BLOCKED;                
        }
        
        //Find out whether the cave is blocked or not
        public boolean isBlocked() {        
                switch (this.cave) {                
                case BLOCKED:                        
                        return true;                        
                		default:                        
                        return false;
                }
        }
        
        //Mark the cave as a pit
        public void makePit() {                
                this.cave = CaveType.PIT;                
        }
        
        //Find out whether the cave is a pit or not
        public boolean isPit() {                
                switch (this.cave) {                
                        case PIT:                        
                                return true;                        
                        default:                        
                                return false;        
                }
        }

        //Mark as a teleport
        public void makeTeleport() {                
                this.cave = CaveType.TELEPORT;                
        }
        
        //Find out whether or not the cave is a teleport
        public boolean isTeleport() {                
                switch (this.cave) {                
                        case TELEPORT:                        
                                return true;        
                }                
                return false;                
        }
        
                
}
