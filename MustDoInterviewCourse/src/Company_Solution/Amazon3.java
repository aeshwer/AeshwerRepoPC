package Company_Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicReference;

public class Amazon3 {

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public ArrayList<String> popularNFeatures(int numFeatures, int topFeatures, List<String> possibleFeatures,
			int numFeatureRequests, List<String> featureRequests) {
		// WRITE YOUR CODE HERE
		int freq[] = new int[numFeatures];
		possibleFeatures.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});

		Iterator<String> iterator = featureRequests.iterator();
		AtomicReference<Integer> i = new AtomicReference<>(0);
		while (iterator.hasNext()) {
			String sentence = iterator.next();
			i.set(0);
			possibleFeatures.forEach(feature -> {
				fillFreqArray(sentence, feature, freq, i.get());
				i.set(i.get() + 1);
			});

		}

		Map<Integer, List<String>> res = new TreeMap<>(Comparator.reverseOrder());

		for (int j = 0; j < numFeatures; j++) {
			if (res.containsKey(freq[j])) {
				List<String> list = res.get(freq[j]);
				list.add(possibleFeatures.get(j));
			} else {
				List<String> list = new ArrayList<>();
				list.add(possibleFeatures.get(j));
				res.put(freq[j], list);
			}
		}

		/*
		 * List<String> finalResultList = new ArrayList<>(); AtomicReference<Integer> c
		 * = new AtomicReference<>(topFeatures); while (topFeatures >= 0) {
		 * res.forEach((k,v)-> { v.forEach(val -> { finalResultList.add(val);
		 * c.set(c.get()-1); if(c.get()==0) {
		 * 
		 * } }); }); }
		 */

		List<String> finalResultList = new ArrayList<>();
		for (Map.Entry<Integer, List<String>> m : res.entrySet()) {
			List<String> featureListForThisFreq = m.getValue();
			Iterator<String> iterator2 = featureListForThisFreq.iterator();
			while (iterator2.hasNext() && topFeatures > 0) {
				finalResultList.add(iterator2.next());
				topFeatures--;

			}

		}
		return (ArrayList<String>) finalResultList;

	}

	private void fillFreqArray(String sentence, String feature, int[] freq, int index) {
		Boolean found = Arrays.asList(sentence.split(" ")).contains(feature);
		if(found) {
			freq[index]=freq[index]+1;
		}

	}

	public static void main(String[] args) {

	}
}
