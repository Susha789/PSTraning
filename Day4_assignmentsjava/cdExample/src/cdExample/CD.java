package cdExample;

import java.util.Objects;

public class CD {
	
	private String Title;
    private String Singer;
	
    public CD(String title, String singer) {
		super();
		Title = title;
		Singer = singer;
	}

	public String getTitle() {
		return Title;
	}

	public String getSinger() {
		return Singer;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public void setSinger(String singer) {
		Singer = singer;
	}

	@Override
	public String toString() {
		return "CD [Title=" + Title + ", Singer=" + Singer + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Singer, Title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CD other = (CD) obj;
		return Objects.equals(Singer, other.Singer) && Objects.equals(Title, other.Title);
	}

    

}
