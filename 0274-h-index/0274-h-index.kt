class Solution {
  fun hIndex(citations: IntArray): Int {
    val n = citations.size
      
    // k번 인용 횟수를 가진 논문의 수를 저장한다.
    // 3, 0, 6, 1, 5의 인용 횟수를 갖는다면,
    // 1, 1, 0, 1, 2으로 각각의 인덱스만큼의 인용 횟수를 가진 논문의 수를 저장한다.
    // 단, n보다 큰 인용 횟수는 n으로 간주한다.
    val papers = IntArray(citations.size + 1) { 0 }
        
    for (citation in citations) {
      papers[kotlin.math.min(n, citation)] += 1
    }   
  
    // k는 인용 횟수로 n부터 시작해서 0까지 간다.
    // s는 k 인용 횟수보다 더 많이 인용된 논문의 수다.
    var k = n // n부터 시작
    var s = papers[n] // n번 인용한 논문의 수
    
    while (k > s) { // k번의 이상의 인용 횟수를 가진 논문의 수를 확인
      k -= 1 // 인용 횟수를 줄임
      s += papers[k] // 줄인 인용 횟수에 대한 논문의 수를 누적
    }
    
    return k
  }
}