package school.博弈问题;
/*
     井字棋: 有平局的博弈

  f(局面) --> 胜负平
  {
  	tag = 负;
  	for(对所有可走的位置)
  	{
  		试走 --> 局面y
  		结果 t = f(y);
  		if(t==负)  return 胜
  		if(t==平)  tag = 可以逼平
  	}

  	return tag;
  }
 =============================
 现实的算法：
   不能计算到最终的胜负   考量各种不同的局面   进行 打分

*/
public class 井字棋 {
	public static void main(String[] args) {

	}
}
