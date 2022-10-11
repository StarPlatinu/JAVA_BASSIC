package fa.training.stringdemo;

public class StringImmutableExample {

	/**
	 * Show an demonstration about immutable characteristic of String in Java. 14. *
	 * 15.
	 */
	public void demonstrateStringImmutable() {
		System.out.println("demonstrateStringImmutable() !!!");
		// "Java" String created in pool and reference assigned to s1
		String s1 = "Java";
		// s2 is also having the same reference to "Java" in the pool
		String s2 = s1;
		// proof that s1 and s2 have same reference
		System.out.println(s1 == s2);
		s1 = "Python";
		// s1 value got changed above, so how String is immutable?

		// well, in above case a new String "Python" got created in the pool
		// s1 is now referring to the new String in the pool
		// BUT, the original String "Java" is still unchanged and
		// remains in the pool
		// s2 is still referring to the original String "Java" in the pool
		// proof that s1 and s2 have different reference
		System.out.println(s1 == s2);
		System.out.println(s2);
		// prints "Java" supporting the fact that
		// original String value is unchanged, hence String is immutable
	}
}
