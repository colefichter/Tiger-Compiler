class interp {
	
	/*Begin exercise part 2, page 12*/
  static void interp(Stm s) { 
	  /* you write this part */
	  interpStm(s, null);
  }
  
  static Table interpStm(Stm s, Table t){
	  if (s.getClass() == CompoundStm.class){
		  Table cs1 = interpStm(((CompoundStm)s).stm1, t);
		  return interpStm(((CompoundStm)s).stm2, cs1);		  
	  }
	  else if (s.getClass() == AssignStm.class){
		  IntAndTable as1 = interpExp(((AssignStm)s).exp, t);
		  return new Table( ((AssignStm)s).id, as1.i, as1.t);
	  }
	  else if (s.getClass() == PrintStm.class){		  
		  return print(((PrintStm)s).exps, t);
	  }
	  
	  return null;
  }
  
  static Table print(ExpList e, Table t) {
	  if (e.getClass() == PairExpList.class) {
		  IntAndTable p1 = interpExp(((PairExpList)e).head, t);
		  System.out.print(p1.i + " ");
		  return print(((PairExpList)e).tail, p1.t);
	  }
	  else {
		  IntAndTable p2 = interpExp(((LastExpList)e).head, t);
		  System.out.println(p2.i + " ");
		  return p2.t;
	  }
  }
  
  static IntAndTable interpExpList(ExpList e, Table t) {
	  if (e.getClass() == PairExpList.class) {
		  IntAndTable pe1 = interpExp(((PairExpList)e).head, t);
		  return interpExpList(((PairExpList)e).tail, pe1.t);
	  }
	  else if (e.getClass() == LastExpList.class) {
		  return interpExp(((LastExpList)e).head, t);
	  }
	  
	  //this shouldn't happen...
	  return null;
  }
  
  static IntAndTable interpExp(Exp e, Table t){
	  if (e.getClass() == IdExp.class){
		  return new IntAndTable(t.lookup(((IdExp)e).id), t);
	  }
	  else if (e.getClass() == NumExp.class) {
		  return new IntAndTable(((NumExp)e).num, t);
	  }
	  else if (e.getClass() == OpExp.class) {
		  IntAndTable oe1 = interpExp(((OpExp)e).left, t);
		  IntAndTable oe2 = interpExp(((OpExp)e).right, oe1.t);
		  switch(((OpExp)e).oper)
		  {
		  	case 1:		  	
		  		return new IntAndTable(oe1.i + oe2.i, oe2.t);
		  	case 2:
		  		return new IntAndTable(oe1.i - oe2.i, oe2.t);		  		
		  	case 3:
		  		return new IntAndTable(oe1.i * oe2.i, oe2.t);
		  	case 4:
		  		return new IntAndTable(oe1.i / oe2.i, oe2.t);		  		
		  }		  
	  }
	  else if (e.getClass() == EseqExp.class){
		  Table es1 = interpStm(((EseqExp)e).stm, t);
		  return interpExp(((EseqExp)e).exp, es1);
	  }
	  
	  return null;
  }
      
  /*End exercise part 2, page 12*/

  /*Begin exercise part 1, page 12*/
  static int maxargs(Stm s) { 
	  /* you write this part */
	  if (s.getClass() == CompoundStm.class)
	  {
		  int cs1 = maxargs(((CompoundStm)s).stm1);
		  int cs2 = maxargs(((CompoundStm)s).stm2);
		  
		  return cs1 > cs2 ? cs1 : cs2;		  
	  }
	  else if (s.getClass() == AssignStm.class)
	  {
		  return maxargs(((AssignStm)s).exp);		  
	  }
	  else if (s.getClass() == PrintStm.class)
	  {
		  return maxargs(((PrintStm)s).exps, 0);
	  }
	  
	  return 0;
  }
  
  static int maxargs(Exp e){
	  if (e.getClass() == IdExp.class){
		  return 0;
	  }	  
	  else if (e.getClass() == NumExp.class)
	  {
		  return 0;
	  }
	  else if (e.getClass() == OpExp.class)
	  {
		  int oe1 = maxargs(((OpExp)e).left);
		  int oe2 = maxargs(((OpExp)e).right);		  
		  return oe1 > oe2 ? oe1 : oe2;		  
	  }
	  else if (e.getClass() == EseqExp.class)
	  {
		  int ee1 = maxargs(((EseqExp)e).stm);
		  int ee2 = maxargs(((EseqExp)e).exp);
		  return ee1 > ee2 ? ee1 : ee2;		  
	  }
	    
	  return 0;
  }
  
  static int maxargs(ExpList l, int count){
	  if (l.getClass() == PairExpList.class){
		  return maxargs(((PairExpList)l).tail, count + 1);
	  }
	  else if (l.getClass() == LastExpList.class)
	  {	
		  return count + 1;
	  }	  
	  
	  return 0;
  }
  /*End exercise part 1, page 12*/
  
  public static void main(String args[]) throws java.io.IOException {
     System.out.println("Max PrintStm args: " + maxargs(prog.prog));
     interp(prog.prog);
  }
}