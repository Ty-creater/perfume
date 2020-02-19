package entity;

public class Items {
	 	private int Id;//id 
	    private String Name;//������
	    private String EngName;//Ӣ����
	    private String Brand;//Ʒ��
	    private double Price;//�۸�
	    private String Photo;//��Ƭ
	    private String Desc;//����
	    private int Stock; //���
	    public Items() {
	    }
		public int getId() {
			return Id;
		}
		public void setId(int id) {
			this.Id = id;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			this.Name = name;
		}
		public String getEngName() {
			return EngName;
		}
		public void setEngName(String engName) {
			this.EngName = engName;
		}
		public String getBrand() {
			return Brand;
		}
		public void setBrand(String brand) {
			this.Brand = brand;
		}
		public double getPrice() {
			return Price;
		}
		public void setPrice(double price) {
			this.Price = price;
		}
		public String getPhoto() {
			return Photo;
		}
		public void setPhoto(String photo) {
			this.Photo = photo;
		}
		public String getDesc() {
			return Desc;
		}
		public void setDesc(String desc) {
			this.Desc = desc;
		}
		public int getStock() {
			return Stock;
		}
		public void setStock(int stock) {
			this.Stock = stock;
		}
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return this.getId()+this.getName().hashCode();
		}
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			if(this==obj)
			{
				return true;
			}
			if(obj instanceof Items)
			{
				Items i = (Items)obj;
				if(this.getId()==i.getId()&&this.getName().equals(i.getName()))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
}
