abstract class Stm {}

class CompoundStm extends Stm {
   Stm stm1, stm2;
   CompoundStm(Stm s1, Stm s2) {stm1=s1; stm2=s2;}
}

class AssignStm extends Stm {
   String id; Exp exp;
   AssignStm(String i, Exp e) {id=i; exp=e;}
}

class PrintStm extends Stm {
   ExpList exps;
   PrintStm(ExpList e) {exps=e;}
}

abstract class Exp {}

class IdExp extends Exp {
   String id;
   IdExp(String i) {id=i;}
}

class NumExp extends Exp {
   int num;
   NumExp(int n) {num=n;}
}

class OpExp extends Exp {
   Exp left, right; int oper;
   final static int Plus=1,Minus=2,Times=3,Div=4;
   OpExp(Exp l, int o, Exp r) {left=l; oper=o; right=r;}
}

class EseqExp extends Exp {
   Stm stm; Exp exp;
   EseqExp(Stm s, Exp e) {stm=s; exp=e;}
}

abstract class ExpList {}

class PairExpList extends ExpList {
   Exp head; ExpList tail;
   public PairExpList(Exp h, ExpList t) {head=h; tail=t;}
}

class LastExpList extends ExpList {
   Exp head; 
   public LastExpList(Exp h) {head=h;}
}

/*Page 13 says to create this class for the interpreter in exercise 2*/
class Table {
	String id; int value; Table tail;
	public Table(String i, int v, Table t) { id=i; value=v; tail=t; }
	
	public static Table update(String i, int v, Table t){
		return new Table(i, v, t);		
	}
	
	public int lookup(String key){
		if (id == key)
		{
			return value;
		}
		else
		{
			return tail.lookup(key);			
		}
	}
}

/*Page 14 says to define IntAndTable class for the interpreter in exercise 2*/
class IntAndTable{
	int i; Table t;
	IntAndTable(int ii, Table tt) {i = ii; t = tt; }
}