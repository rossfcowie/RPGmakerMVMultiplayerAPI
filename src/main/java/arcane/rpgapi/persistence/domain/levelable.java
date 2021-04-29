package arcane.rpgapi.persistence.domain;

public interface levelable {
	public void levelUp();
	public void gainExp(long gained);
}
