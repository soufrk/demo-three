package designpatterns;

/**
 * Simple builder implementation.
 * 
 * @author soufrk
 *
 */
public class Builder01 {

	private int first, second, third, fourth;

	/* public Builder01(){} */
	private Builder01() {}

	public static void main(String[] args) {
		Builder01 instacne = new Builder01.Builder()
				.setFirst(0)
				.setSecond(1)
				.setThird(2)
				.setFourth(3)
				.build();
		System.out.println(instacne);

	}

	@Override
	public String toString() {
		return "Builder01 [first=" + first + ", second=" + second + ", third=" + third + ", fourth=" + fourth + "]";
	}

	public static class Builder {

		private int first, second, third, fourth;

		public Builder01 build() {
			Builder01 instance = new Builder01();
			instance.first = this.first;
			instance.second = this.second;
			instance.third = this.third;
			instance.fourth = this.fourth;
			return instance;
		}

		public int getFirst() {
			return first;
		}

		public Builder setFirst(int first) {
			this.first = first;
			return this;
		}

		public int getSecond() {
			return second;
		}

		public Builder setSecond(int second) {
			this.second = second;
			return this;
		}

		public int getThird() {
			return third;
		}

		public Builder setThird(int third) {
			this.third = third;
			return this;
		}

		public int getFourth() {
			return fourth;
		}

		public Builder setFourth(int fourth) {
			this.fourth = fourth;
			return this;
		}

	}

}
