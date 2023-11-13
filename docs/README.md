# 기능 목록 - 크리스마스 프로모션

## 🎯 핵심 기능
> **식당 방문 날짜와 주문 정보를 기반으로 이벤트 혜택을 계산**

## 🗂️ 프로젝트 구조

<div align="center">
<table>
<thead>
  <tr>
    <th colspan="2">패키지</th>
    <th>클래스</th>
    <th>설명</th>
  </tr>
<tr><td colspan="4"></td></tr>
</thead>
<tbody>
  <tr>
    <td rowspan="12"><b>📁 domain</b></td>
    <td rowspan="3"><b>benefit</b></td>
    <td><b><img align="center" src="https://github.com/woowacourse-precourse/kotlin-lotto-6/assets/69251013/11d70dca-1478-45e0-857e-cc4571cffc9b" height="24px">&nbsp;&nbsp;Benefit</b></td>
    <td>혜택 정보를 나타내는 클래스<br>혜택 유형(BenefitType), 혜택 이름(String), 금액(Money)로 구성</td>
  </tr>
  <tr>
    <td><b><img align="center" src="https://github.com/woowacourse-precourse/kotlin-lotto-6/assets/69251013/11d70dca-1478-45e0-857e-cc4571cffc9b" height="24px">&nbsp;&nbsp;Benefits</b></td>
    <td>여러 개의 혜택 정보를 관리하는 클래스<br>List&lt;Benefit&gt;로 구성</td>
  </tr>
  <tr>
    <td><b><img align="center" src="https://github.com/woowacourse-precourse/kotlin-lotto-6/assets/69251013/f652ba30-943c-427d-bd9f-796790c01a13" height="24px">&nbsp;&nbsp;BenefitType</b></td>
    <td>혜택 유형을 정의하는 Enum 클래스</td>
  </tr>
    <td rowspan="5"><b>menu</b></td>
   <td><b><img align="center" src="https://github.com/woowacourse-precourse/kotlin-lotto-6/assets/69251013/11d70dca-1478-45e0-857e-cc4571cffc9b" height="24px">&nbsp;&nbsp;Orders</b></td>
    <td>주문 정보들을 나타내는 클래스<br>EnumMap&lt;Menu, MenuCount&gt;로 구성</td>
  </tr>
    <td><b><img align="center" src="https://github.com/woowacourse-precourse/kotlin-lotto-6/assets/69251013/11d70dca-1478-45e0-857e-cc4571cffc9b" height="24px">&nbsp;&nbsp;FreeGift</b></td>
    <td>증정 상품을 나타내는 클래스<br>증정 메뉴(Menu)와 증정 개수(MenuCount)로 구성</td>
  </tr>

  <tr>
     <td><b><img align="center" src="https://github.com/woowacourse-precourse/kotlin-lotto-6/assets/69251013/f652ba30-943c-427d-bd9f-796790c01a13" height="24px">&nbsp;&nbsp;Menu</b></td>
    <td>메뉴를 정의하는 Enum 클래스<br>메뉴 카테고리(MenuCategory), 이름(String), 가격(Money)으로 구성</td>
  </tr>

  <tr>
    <td><b><img align="center" src="https://github.com/woowacourse-precourse/kotlin-lotto-6/assets/69251013/f652ba30-943c-427d-bd9f-796790c01a13" height="24px">&nbsp;&nbsp;MenuCategory</b></td>
    <td>메뉴 카테고리를 정의하는 Enum 클래스</td>
  </tr>

   <tr>
    <td><b><img align="center" src="https://github.com/woowacourse-precourse/kotlin-lotto-6/assets/69251013/11d70dca-1478-45e0-857e-cc4571cffc9b" height="24px">&nbsp;&nbsp;MenuCount</b></td>
    <td>메뉴 개수 원시값(Int)을 포장하는 클래스</td>
  </tr>

   <tr>
    <td></td>
    <td><b><img align="center" src="https://github.com/woowacourse-precourse/kotlin-lotto-6/assets/69251013/11d70dca-1478-45e0-857e-cc4571cffc9b" height="24px">&nbsp;&nbsp;DecemberDay</b></td>
    <td>12월의 일(day)을 나타내는 클래스<br>평일/주말 여부 등 날짜 관련 메서드 제공</td>
  </tr>
  <tr>
    <td></td>
    <td><b><img align="center" src="https://github.com/woowacourse-precourse/kotlin-lotto-6/assets/69251013/11d70dca-1478-45e0-857e-cc4571cffc9b" height="24px">&nbsp;&nbsp;DecemberEvent</b></td>
    <td>예약일과 예약 메뉴들을 바탕으로 혜택을 계산하는 클래스</td>
  </tr>
   <tr>
    <td></td>
    <td><b><img align="center" src="https://github.com/woowacourse-precourse/kotlin-lotto-6/assets/69251013/f652ba30-943c-427d-bd9f-796790c01a13" height="24px">&nbsp;&nbsp;EventBadge</b></td>
    <td>이벤트 배지를 정의하는 Enum 클래스</td>
  </tr>
   <tr>
    <td></td>
    <td><b><img align="center" src="https://github.com/woowacourse-precourse/kotlin-lotto-6/assets/69251013/11d70dca-1478-45e0-857e-cc4571cffc9b" height="24px">&nbsp;&nbsp;Money</b></td>
    <td>프로그램 내 통용되는 화폐를 나타내는 클래스</td>
  </tr>
<tr><td colspan="4"></td></tr>
  <tr>
    <td colspan="2" rowspan="2"><b>⚠️ exception</b></td>
    <td><b><img align="center" src="https://github.com/woowacourse-precourse/kotlin-lotto-6/assets/69251013/f652ba30-943c-427d-bd9f-796790c01a13" height="24px">&nbsp;&nbsp;DecemberDayException</b></td>
    <td>12월 날짜 관련 예외 메시지를 모아둔 Enum 클래스</td>
  </tr>
  <tr>
    <td><b><img align="center" src="https://github.com/woowacourse-precourse/kotlin-lotto-6/assets/69251013/f652ba30-943c-427d-bd9f-796790c01a13" height="24px">&nbsp;&nbsp;OrdersException</b></td>
    <td>주문 정보 관련 예외 메시지를 모아둔 Enum 클래스</td>
  </tr>
<tr><td colspan="4"></td></tr>
  <tr>
    <td colspan="2" rowspan="2"><b>🖥️ view</b></td>
    <td><b><img align="center" src="https://github.com/woowacourse-precourse/kotlin-lotto-6/assets/69251013/11d70dca-1478-45e0-857e-cc4571cffc9b" height="24px">&nbsp;&nbsp;InputView</b></td>
    <td>사용자 입력을 담당하는 뷰 클래스</td>
  </tr>
  <tr>
    <td><b><img align="center" src="https://github.com/woowacourse-precourse/kotlin-lotto-6/assets/69251013/11d70dca-1478-45e0-857e-cc4571cffc9b" height="24px">&nbsp;&nbsp;OutputView</b></td>
    <td>출력을 담당하는 뷰 클래스</td>
  </tr>
  <tr><td colspan="4"></td></tr>
  <tr>
    <td colspan="2" rowspan="1"><b>🕹️ controller</b></td>
    <td><b><img align="center" src="https://github.com/woowacourse-precourse/kotlin-lotto-6/assets/69251013/11d70dca-1478-45e0-857e-cc4571cffc9b" height="24px">&nbsp;&nbsp;DecemberEventController</b></td>
    <td>프로그램의 흐름을 관리하고 로직을 조율하는 클래스</td>
  </tr>
<tr><td colspan="4"></td></tr>
  <tr>
    <td colspan="3"><b>🚀 Application</b></td>
    <td>View와 핵심 Domain객체를 생성하여 Controller에 주입 및 실행</td>
  </tr>
</tbody>
</table>
</div>

## 📋 절차

1. **인사말 출력**
    * [Controller] View에 인사말 출력 요청
    * [OutputView] 인사말 출력

2. **12월 중 식당 예상 방문 날짜 입력 받기**
    * [Controller] View에 방문 날짜 입력 요청
    * [InputView] 사용자로부터 방문 날짜 입력
    * [Domain] 입력받은 문자열 날짜로 도메인 생성
    * [Controller] 위 과정 중 예외 발생시 재입력 요청

3. **주문할 메뉴와 개수 입력 받기**
   * [Controller] View에 주문할 메뉴 및 개수 입력 요청
   * [InputView] 사용자로부터 주문할 메뉴 및 개수 입력
   * [Domain] 입력받은 문자열로 주문 목록 도메인 생성
   * [Controller] 위 과정 중 예외 발생시 재입력 요청

4. **혜택 미리보기 제목 출력**
   * [Controller] 방문 날짜를 문자열로 변환하여 View에 전달 및 제목 출력 요청
   * [OutputView] 혜택 미리보기 제목 출력

5. **주문 메뉴 출력**
   * [Controller] 주문 메뉴를 문자열로 변환하여 View에 출력 요청
   * [OutputView] 입력받은 문자열 출력

6. **할인 전 총주문 금액 출력**
   * [Domain] 할인 전 총주문 금액 계산
   * [Controller] 문자열로 변환하여 View에 출력 요청
   * [Domain] 문자열 변환 override
   * [OutputView] 입력받은 문자열 출력

7. **증정 이벤트 해당 여부 출력**
   * [Domain] 증정 이벤트 해당 여부 계산 및 상품 반환
   * [Controller] 상품이 있으면 문자열로 변환, 없으면 "없음" View에 출력 요청
   * [Domain] 상품이 있으면 문자열 변환 override
   * [OutputView] 입력받은 문자열 출력

8. **혜택 내역 출력**
   * [Domain] 예약 날짜 및 주문을 받아 혜택 내역 반환
   * [Controller] 문자열로 변환하여 View에 출력 요청
   * [Domain] 문자열 변환 override
   * [OutputView] 입력받은 문자열 출력

9. **총혜택 금액 출력**
   * [Domain] 총혜택 금액 반환
   * [Controller] null이라면 0으로 변경
   * [Controller] 문자열로 변환하여 View에 출력 요청
   * [Domain] 문자열 변환 override
   * [OutputView] 입력받은 문자열 출력

10. **할인 후 예상 결제 금액 출력**
    * [Domain] 혜택 중 할인 금액 반환
    * [Controller] 총주문 금액에서 할인 금액 차감
    * [Controller] 문자열로 변환하여 View에 출력 요청
    * [OutputView] 입력받은 문자열 출력

11. **12월 이벤트 배지 출력**
    * [Domain] 총혜택 금액을 입력받아 해당하는 배지 반환
    * [Controller] 문자열로 변환하여 View에 출력 요청
    * [OutputView] 입력받은 문자열 출력

## ⌨️ 입력
- **12월 중 식당 예상 방문 날짜**
```
출력 : 12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
입력 : (숫자 입력)

⚠️ 예외 처리(Domain - DecemberDay) :
- 숫자가 아닌 다른 문자열 입력
- 숫자의 범위가 1 이상 31 이하가 아닌 경우
```
- **주문할 메뉴와 개수**
```
출력 : 주문하실 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
입력 : ("메뉴-개수" 형식을 쉼표(,)를 기준으로 입력)

⚠️ 예외 처리(Domain - Orders) :
- (문자열-숫자,문자열-숫자...) 형식 외 입력
- 메뉴의 카테고리가 음료밖에 없는 경우
- 메뉴의 총 개수가 20개를 초과
- 해당하는 메뉴가 없는 경우
- 중복된 메뉴 존재

⚠️ 예외 처리(Domain - MenuCount) :
- 메뉴의 개수가 1 미만인 경우
```
## 🖥️ 출력
- **인사말**
```
안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
```
- **혜택 미리보기 제목**
```
12월 n일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
```
- **주문 메뉴**
```
<주문 메뉴>
메뉴명1 n개
메뉴명2 n개
메뉴명3 n개
...
```
- **할인 전 총주문 금액**
```
<할인 전 총주문 금액>
100,000원
```
- **증정 메뉴**
```
<증정 메뉴>
샴페인 1개
```
- **혜택 내역**
```
<혜택 내역>
크리스마스 디데이 할인: -1,200원
평일 할인: -4,046원
특별 할인: -1,000원
증정 이벤트: -25,000원
```
- **총혜택 금액**
```
<총혜택 금액>
-31,246원
```
- **할인 후 예상 결제 금액**
```
<할인 후 예상 결제 금액>
135,754원
```
- **12월 이벤트 배지**
```
<12월 이벤트 배지>
산타
```