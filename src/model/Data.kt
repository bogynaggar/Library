package model

import java.time.LocalDate
import java.util.Calendar

  class Data {

      companion object {

          var librarianList = mutableListOf<Librarian>(
              Librarian(1001, "naggar", "12345", "Mostafa El-Naggar", "Tanta", "01002894449", "manager"),
              Librarian(1002, "alya", "54321", "Alya El-Naggar", "tanta", "01142006928", "librarian ")
          )

          var readerList = mutableListOf<Reader>(
              Reader(2001, "mohamed", "123456", "Mohamed El-Naggar", "Tanta", "01000507060", "high", "male"),
              Reader(2002, "ahmed", "654321", "Ahmed Ali", "cairo", "01145644562", "medium", "male")
          )


          var authorList = mutableListOf<Author>(
              Author(3001, "Whalen Karen", "Florida USA", "0100505060", "University of Florida"),
              Author(3002, "Ahmed Morad", "Cairo", "01000000", "Free"),
              Author(3003, "Salah Jahin", "Cairo", "Dead", "Free"),
              // Author(3004 , ) ,
              // Author(3005 , ) ,
          )

          var bookList = mutableListOf<Book>(
              Book(
                  4001,
                  "Lippincott Pharmacology",
                  "70",
                  "Pharmacology",
                  "Whalen Karen",
                  "Whalen Karen",
                  "2018-1-1",
                  "English"
              ),
              Book(4002, "Torab Almas", "50", "Drama", "Ahmed Morad", "Dar Elshorouk", "2018-1-1", "Arabic"),
              Book(
                  4003,
                  "Roba'yat Salah Jahin",
                  "80",
                  "Arabic literature",
                  "Salah Jahin",
                  "Maktabet Alosrah",
                  "1959-1-1",
                  "Arabic"
              ),
              // Book(4004 , ),
              // Book(4005 , ),
          )

          var publisherList = mutableListOf<Publisher>(
              Publisher(5001, "Whalen Karen", "Florida USA", "015846145", "Williams & Wilkin"),
              Publisher(5002, "Dar Elshorouk", "Cairo", "012052050", "Dar Elshorouk"),
              Publisher(5003, "Maktabet Alosrah", "Cairo", "0114205305", "Maktabet Alosrah"),
              // Publisher(5004 , ),
              // Publisher(5005 , ),
          )


          var borrowedBooksList = mutableListOf<Borrow>(
              Borrow(2001, 4002, LocalDate.of(2024, 4, 20), LocalDate.of(2024, 5, 20)),
              Borrow(2001, 4001, LocalDate.of(2024, 5, 21), LocalDate.of(2024, 7, 21)),

              )

      }



}