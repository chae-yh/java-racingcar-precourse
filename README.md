# 자동차 경주 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록
* 입력 값 쉼표 기준으로 이름 구분 []
* 자동차 이름 입력 값 검증
    * 각 이름은 5자 이하이고 최소 한글자 이상 [O]
    * 영어와 숫자만 입력 가능 [O]
    * 가능한 자동차 최대 개수 제한(예 : 10대) [O]
    * 가능한 자동차 최소 개수 제한(1대 이상) [O]
    * 동일한 이름이 들어가면 한 개의 자동차로 취급 [O]
* 이동 입력 값 검증
    * 숫자만 입력 [O]
    * 0보다 크고 특정값보다 작을 것(예 : 100) [O]
* 랜덤 값 검증
    * 값은 0에서 9 사이만 가능 [O]
* 자동차는 값이 4이상일 경우 전진하고 3이하 이면 멈춤 [O]
* 레이싱 검증
    * 한 번의 레이스에 최대 1만큼 이동 []
    * 경기가 끝나면 자동차는 움직이지 않음 []
    * 게임 완료 후 누가 우승했는지 확인 []
