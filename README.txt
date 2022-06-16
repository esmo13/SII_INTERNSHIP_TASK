 Użytkownik może obejrzeć plan konferencji
GET http://localhost:8080/api/lessons

 Użytkownik po podaniu swojego loginu może obejrzeć prelekcje na które się zapisał

GET http://localhost:8080/api/lessons/{{login}}

 Rezerwacja miejsca na prelekcji(jeśli jest miejsce) przy użyciu loginu i hasła

PUT http://localhost:8080/api/lessons/{{lessonID}}
Content-Type: application/json

{
  "login":"test",
  "email":"tst@test.pl"
}

Użytkownik może anulować rezerwację
PUT http://localhost:8080/api/lessons/unsign/{{lessonID}}
Content-Type: application/json

{
  "login":"test",
  "email":"tst@test.pl"
}

Użytkownik może zaktualizować swój adres email
PUT http://localhost:8080/api/users/{{userID}}
Content-Type: application/json

{
  "email":"newEmail@mail.eu"
}

Zestawienie wykładów wg. zainteresowania (procentowy udział uczestników w wykładzie)
GET http://localhost:8080/api/lessons/org/lessons

Zestawienie ścieżek tematycznych wg. zainteresowania (procentowy udział)
GET http://localhost:8080/api/lessons/org/topics