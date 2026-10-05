import { TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { BookReservation } from './book-reservation';
import { BookService } from '../../services/book.service';

describe('BookReservation', () => {
  it('reserve : le livre doit être BOOKED', () => {
    const book = { id: 3, name: 'Gatsby', description: 'American dream', status: 'BOOKED' };

    TestBed.configureTestingModule({
      imports: [BookReservation],
      providers: [
        {
          provide: BookService,
          useValue: {
            reserve: () => of(book),
            getAllBooks: () => of([book]),
            notGet: () => of([]),
          },
        },
      ],
    });

    const component = TestBed.createComponent(BookReservation).componentInstance;
    component.reserve(3);

    expect(component.books[0].status).toBe('BOOKED');
  });
});
