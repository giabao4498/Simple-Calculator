import java.util.*;
interface Intro1{
	String intro1="Chao mung den voi chuong trinh tinh toan don gian!\n1.Nhap bieu thuc can tinh\n2.Huong dan\n3.Thoat\nMoi ban nhap chon lua bang SO (1 hoac 2 hoac 3): ";
}
interface Intro2{
	public void intro2();
}
class Intro implements Intro1,Intro2{
	public void intro2(){
		System.out.print(intro1);
	}
}
class pheptinh{
	double a,b;
}
class Cong extends pheptinh{
	double c;
}
class Tru extends pheptinh{
	double c;
}
class Nhan extends pheptinh{
	double c;
}
class Chia extends pheptinh{
	double c;
}
public class Gia_Bao {
	static String cal(){
		System.out.println("Nhap \"back\" de quay lai menu chinh, \"exit\" de thoat chuong trinh");
		System.out.println("Luu y cac lenh tren khi nhap khong phan biet chu hoa chu thuong va co the du khoang trang o dau va cuoi. Chi tiet hon xem phan huong dan");
		Scanner inp0 = new Scanner(System.in);
		String cmd;
		do{
			System.out.println("Nhap bieu thuc can tinh hoac lenh: ");
			cmd=inp0.nextLine().trim();
			if (!((cmd.equalsIgnoreCase("back")) || (cmd.equalsIgnoreCase("exit"))))
			{
				int mo,dong=0;
				if ((!((cmd.charAt(0)=='(') || (cmd.charAt(0)=='0') || (cmd.charAt(0)=='1') || (cmd.charAt(0)=='2') || (cmd.charAt(0)=='3') || (cmd.charAt(0)=='4') || (cmd.charAt(0)=='5') || (cmd.charAt(0)=='6') || (cmd.charAt(0)=='7') || (cmd.charAt(0)=='8') || (cmd.charAt(0)=='9') || (cmd.charAt(0)=='-'))) || (cmd.charAt(cmd.length()-1)=='+') || (cmd.charAt(cmd.length()-1)=='-') || (cmd.charAt(cmd.length()-1)=='x') || (cmd.charAt(cmd.length()-1)=='X') || (cmd.charAt(cmd.length()-1)=='*') || (cmd.charAt(cmd.length()-1)=='/') || (cmd.charAt(cmd.length()-1)==':') || (cmd.charAt(cmd.length()-1)=='.') || (cmd.charAt(cmd.length()-1)==','))
					System.out.println("Bieu thuc hoac lenh khong hop le! Vui long nhap lai");
				else{
					if (cmd.charAt(0)=='(') mo=1;
					else{
						mo=0;
						if ((cmd.charAt(0)=='-') && (cmd.length()>1) && (cmd.charAt(1)=='(')) cmd='0'+cmd;
					}
					int i=0;
					while (i+1<cmd.length())
					{
						++i;
						switch (cmd.charAt(i))
						{
							case ',': cmd=cmd.substring(0,i)+'.'+cmd.substring(i+1);
							case '.': if (!((cmd.charAt(i-1)=='0') || (cmd.charAt(i-1)=='1') || (cmd.charAt(i-1)=='2') || (cmd.charAt(i-1)=='3') || (cmd.charAt(i-1)=='4') || (cmd.charAt(i-1)=='5') || (cmd.charAt(i-1)=='6') || (cmd.charAt(i-1)=='7') || (cmd.charAt(i-1)=='8') || (cmd.charAt(i-1)=='9'))) mo=-1; break;
							case '(': if (cmd.charAt(i-1)!='.')
							{
								++mo;
								if ((cmd.charAt(i-1)=='0') || (cmd.charAt(i-1)=='1') || (cmd.charAt(i-1)=='2') || (cmd.charAt(i-1)=='3') || (cmd.charAt(i-1)=='4') || (cmd.charAt(i-1)=='5') || (cmd.charAt(i-1)=='6') || (cmd.charAt(i-1)=='7') || (cmd.charAt(i-1)=='8') || (cmd.charAt(i-1)=='9') || (cmd.charAt(i-1)==')'))
								{
									cmd=cmd.substring(0,i)+'*'+cmd.substring(i);
									++i;
								}
							}
							else mo=-1; break;
							case ')': if ((cmd.charAt(i-1)=='0') || (cmd.charAt(i-1)=='1') || (cmd.charAt(i-1)=='2') || (cmd.charAt(i-1)=='3') || (cmd.charAt(i-1)=='4') || (cmd.charAt(i-1)=='5') || (cmd.charAt(i-1)=='6') || (cmd.charAt(i-1)=='7') || (cmd.charAt(i-1)=='8') || (cmd.charAt(i-1)=='9'))
							{
								++dong;
								if (mo<dong) mo=-1;
							}
							else mo=-1; break;
							case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': if (cmd.charAt(i-1)==')') mo=-1; break;
							case 'x': case 'X': case ':': if (cmd.charAt(i)==':') cmd=cmd.substring(0,i)+'/'+cmd.substring(i+1);
							else cmd=cmd.substring(0,i)+'*'+cmd.substring(i+1);
							case '+': case '-': case '*': case '/': if ((cmd.charAt(i-1)=='+') || (cmd.charAt(i-1)=='-') || (cmd.charAt(i-1)=='*') || (cmd.charAt(i-1)=='/') || (cmd.charAt(i-1)=='.')) mo=-1;
							else if ((cmd.charAt(i-1)=='(') && ((cmd.charAt(i-1)=='*') || (cmd.charAt(i-1)=='/'))) mo=-1;
							if ((cmd.charAt(i)=='-') && (cmd.charAt(i-1)=='('))
							{
								cmd=cmd.substring(0,i)+'0'+cmd.substring(i);
								++i;
							} break;
							default: mo=-1;
						}
						if (mo==-1) break;						
					}
					if (mo==dong)
					{
						ArrayList<String> kq = new ArrayList<String>(),stack = new ArrayList<String>();
						i=-1;
						String tg="";
						do{
							++i;
							switch (cmd.substring(i,i+1))
							{
								case "(": stack.add(cmd.substring(i,i+1)); break;
								case "+": case "-": if ((!(cmd.substring(i+1,i+2).equals("("))) && (cmd.substring(i,i+1).equals("-")) && ((i==0) || ((i>0) && (cmd.substring(i-1,i).equals("(")))))
								tg="-";
								else while ((!(stack.isEmpty())) && ((!(stack.get(stack.size()-1)).equals("("))))
								{
									kq.add(stack.get(stack.size()-1));
									stack.remove(stack.size()-1);
								}
								if (tg.equals("")) stack.add(cmd.substring(i,i+1)); break;
								case "*": case "/": while (!(stack.isEmpty()) && ((stack.get(stack.size()-1).equals("*")) || (stack.get(stack.size()-1).equals("/"))))
								{
									kq.add(stack.get(stack.size()-1));
									stack.remove(stack.size()-1);
								}
								stack.add(cmd.substring(i,i+1)); break;
								case ")": while (!stack.isEmpty())
								{
									if (!(stack.get(stack.size()-1).equals("(")))
									{
										kq.add(stack.get(stack.size()-1));
										stack.remove(stack.size()-1);
									}
									else{
										stack.remove(stack.size()-1);
										break;
									}
								} break;
								default:
									tg=tg+cmd.substring(i,i+1);
									while ((i+1<cmd.length()) && ((cmd.charAt(i+1)=='0') || (cmd.charAt(i+1)=='1') || (cmd.charAt(i+1)=='2') || (cmd.charAt(i+1)=='3') || (cmd.charAt(i+1)=='4') || (cmd.charAt(i+1)=='5') || (cmd.charAt(i+1)=='6') || (cmd.charAt(i+1)=='7') || (cmd.charAt(i+1)=='8') || (cmd.charAt(i+1)=='9') || (cmd.charAt(i+1)=='.')))
									{
										++i;
										if ((cmd.charAt(i)=='.') && (tg.indexOf('.')>-1))
										{
											i=-1;
											break;
										}
										tg=tg+cmd.charAt(i);
									}
									if (i==-1)
									{
										System.out.println("Bieu thuc hoac lenh khong hop le! Vui long nhap lai");
										break;
									}
									else{
										kq.add(tg);
										tg="";
									}
							}
							if (i==-1) break;
						}
						while (i+1<cmd.length());
						if (i==-1) continue;
						while (!(stack.isEmpty()))
						{
							kq.add(stack.get(stack.size()-1));
							stack.remove(stack.size()-1);
						}
						ArrayList<Double> res = new ArrayList<Double>();
						res.add(Double.parseDouble(kq.get(0)));
						Cong cong = new Cong();
						Tru tru = new Tru();
						Nhan nhan = new Nhan();
						Chia chia = new Chia();
						for (i=1; i<kq.size(); i++)
						switch (kq.get(i))
						{
							case "+": cong.a=res.get(res.size()-2);
							cong.b=res.get(res.size()-1);
							cong.c=cong.a+cong.b;
							res.set(res.size()-2,cong.c);
							res.remove(res.size()-1); break;
							case "-": tru.a=res.get(res.size()-2);
							tru.b=res.get(res.size()-1);
							tru.c=tru.a-tru.b;
							res.set(res.size()-2,tru.c);
							res.remove(res.size()-1); break;
							case "*": nhan.a=res.get(res.size()-2);
							nhan.b=res.get(res.size()-1);
							nhan.c=nhan.a*nhan.b;
							res.set(res.size()-2,nhan.c);
							res.remove(res.size()-1); break;
							case "/": chia.a=res.get(res.size()-2);
							chia.b=res.get(res.size()-1);
							chia.c=chia.a/chia.b;
							res.set(res.size()-2,chia.c);
							res.remove(res.size()-1); break;
							default: res.add(Double.parseDouble(kq.get(i)));
						}
						System.out.println("Ket qua: "+((res.get(0)==0)?Math.abs(res.get(0)):res.get(0)));
					}
					else System.out.println("Bieu thuc hoac lenh khong hop le! Vui long nhap lai");
				}
			}
		}
		while (!((cmd.equalsIgnoreCase("back")) || (cmd.equalsIgnoreCase("exit"))));
		return(cmd);
	}
	static String help(){
		System.out.println("Huong dan su dung chuong trinh:");
		System.out.println("Day la chuong trinh de tinh toan mot bieu thuc don gian gom 4 phep toan cong, tru, nhan, chia co ban va cac dau ngoac");
		System.out.println("Nhap bieu thuc vao va chuong trinh se tinh ra ket qua");
		System.out.println("Quy tac nhap bieu thuc:");
		System.out.println("- Bieu thuc gom cac ki tu so (0; 1; 2; 3; 4; 5; 6; 7; 8; 9), dau cong (+), dau tru (-), dau nhan (x hoac X hoac *), dau chia (/ hoac :) va cac cap ngoac don ()");
		System.out.println("- Luu y: chuong trinh chi su dung ngoac don, khong su dung ngoac vuong [] va ngoac nhon {}");
		System.out.println("         neu sau mot so la dau mo ngoac thi se duoc hieu la so do nhan voi bieu thuc trong ngoac. Vi du: 9(1+3) tuong duong 9*(1+3). Tuong tu voi truong hop hai cap ngoac ke nhau ()() tuong duong ()*()");
		System.out.println("         tuy nhien truong hop dau dong ngoac sau do la ki tu so thi la bieu thuc sai. Vi du: (8+9)10 la bieu thuc sai");
		System.out.println("- Vi du: 1+1, 2*2, (4:3), (1+2)x3/(5-4):6X7*8(10-9) la nhung bieu thuc dung");
		System.out.println("         (), (2+4, [5+6]*6, {4+5*(4+7)} la nhung bieu thuc sai");
		System.out.println("Dung dau cham (.) hoac dau phay (,) de phan biet giua phan nguyen va phan thap phan. Vi du: 123.4 hoac 123,4");
		System.out.println("Ket qua cua bieu thuc duoc tinh theo quy tac toan hoc: trong dau ngoac truoc roi den nhan, chia roi cong, tru");
		System.out.println("***Luu y khi dang o phan nhap bieu thuc:");
		System.out.println("Neu muon quay lai menu chinh thi nhap lenh back, thoat khoi chuong trinh nhap lenh exit***");
		System.out.println("Moi thao tac lenh khong phan biet chu hoa chu thuong, cac bieu thuc va cac lenh khi nhap vao bi du khoang trang o dau va cuoi deu duoc coi la hop le");
		System.out.println("Nhung neu du khoang trang o giua thi khong hop le. Vi du: e xit, ba ck la lenh khong hop le, 9 + 8 -7 la bieu thuc khong hop le");
		System.out.print("Moi ban nhap chon lua (so 3, exit de thoat chuong trinh, chon lua bat ki de quay lai menu chinh): ");
		Scanner inp0 = new Scanner(System.in);
		return(inp0.nextLine().trim());
	}
	public static void main(String[] args) {
		Intro intro = new Intro();
		String choice;
		Scanner inp = new Scanner(System.in);
		do{
			intro.intro2();
			choice=inp.nextLine();
			while (!((choice.equals("1")) || (choice.equals("2")) || (choice.equals("3"))))
			{
				System.out.print("Lenh khong hop le! Moi ban nhap lai: ");
				choice=inp.nextLine();
			}
			System.out.println("--------------------------------------------------");
			switch (choice)
			{
				case "1": choice=cal(); break;
				case "2": choice=help(); break;
			}
			System.out.println("--------------------------------------------------");
		}
		while (!((choice.equals("3")) || (choice.equalsIgnoreCase("exit"))));
		System.out.println("Cam on ban da su dung chuong trinh! Hen gap lai!");
	}

}