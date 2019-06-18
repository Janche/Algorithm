package 浮点数练习;
/**
 * 零精度损失的浮点数运算
 * @author LR
 *
 */
public class Rational {
	
	private long _a; //分子
 	private long _b; //分母
	/*
	 * 求最大公约数
	 */
	public static long _gcd(long x,long y){
		if(x < 0) x = -x;
		if(y < 0) y = -y;
		if(y == 0) return x;
		return _gcd(y,x%y);
	}
	/*
	 * 两个操作数进行化简
	 */
	public Rational(long a,long b){
		long d = _gcd(a,b);
		_a = a / d;
		_b = b / d;
	}
	
	public Rational add(Rational x){
		return new Rational(this._a * x._b + this._b * x._a, this._b * x._b);
	}
	
	public Rational mul(Rational x){
		return new Rational(this._a * x._a, this._b * x._b);
	}
	
	public Rational negative(){
		return new Rational(-this._a, this._b);
	}
	
	public Rational sub(Rational x){
		return add(x.negative());
	}
	
	public Rational inverse(){
		return new Rational(this._b, this._a);
	}
	
	public Rational div(Rational x){
		return mul(x.inverse());
	}
	
	public String toString(){
		if (_b == 1) {
			return "" + _a;
		}else
			return _a + "/" + _b;
	}
	
	public static void main(String[] args){
		Rational a = new Rational(5,1);
		Rational b = new Rational(1,15);
		
		Rational c = a.add(b);
		Rational d = a.div(b);
		Rational e = a.mul(b);
		Rational f = a.sub(b);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
	}
}
