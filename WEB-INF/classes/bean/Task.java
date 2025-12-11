package bean;

public class Task{
	private String name;
	private boolean checka;

	public Task(String name,boolean check){
		this.name = name;
		this.checka = check;
	}

	public void setName(String name){
		this.name = name;
	}
	public void setcheck(boolean check){
		this.checka = check;
	}

	public String getName(){
		return name;
	}
	
	public boolean getcheck(){
		return checka;
	}
}
