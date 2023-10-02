# mydataapi
- 마이데이터 API

# 프로젝트 개요
- 금융분야 마이데이터 표준API 구현(표준API 22년 10월 버전 기준)

# 구현 범위
- 인증 및 업권별(카드, 은행, 보험 등) 정보제공 API
- 회원 정보전송 요구 등록 및 데이터 일괄 수신 등

# 구현 방법
- 업권별/API별로 DB테이블 생성 및 CRUD 개발
- 업권별/API별로 Controller, Model, Service(Interface 포함) 개발
- 종합포털을 통한 공통정보, 인등 처리 등의 역할에 대해서는 mydatagwtestdriver 프로젝트로 별도 구현
  단, 테스트상 한계로 더비 API로 개발
 
# 개발 환경
- Java + Spring Boot + Oracle 11g XE + Mybatis
  
# 기타
- 금융기관으로 정식 등록하지 못하는 한계로 테스트는 미실시
