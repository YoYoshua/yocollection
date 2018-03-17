import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class GameService {
  private sortedBy: String = 'Name';
  private sortedInOrder: String = 'Asc';
  private API = '//localhost:8080';
  private GAME_API = this.API + '/games';
  private SORT_API = this.API + '/games/sortBy=' + this.sortedBy
          + '&' + this.sortedInOrder;

  constructor(private http: HttpClient) {

  }

  getAll(): Observable<any> {
    return this.http.get(this.GAME_API + '/sortBy=Name&Asc');
  }

  get(id: string) {
    return this.http.get(this.GAME_API + '/' + id);
  }

  save(game: any): Observable<any> {
    let result: Observable<Object>;
    if (game['href']) {
      result = this.http.put(game.href, game);
    } else {
      result = this.http.put(this.GAME_API + '/0', game);
    }
    return result;
  }

  remove(href: string) {
    return this.http.delete(href);
  }

  search(game: any): Observable<any> {
    if (game.name) {
      return this.http.get(this.GAME_API + '/search/' + game.name);
    } else {
      return this.http.get(this.GAME_API);
    }
  }

  sortBy(sort: String): Observable<any> {
    this.sortedBy = sort;
    this.SORT_API = this.API + '/games/sortBy=' + this.sortedBy
      + '&' + this.sortedInOrder;
    return this.http.get(this.SORT_API);
  }

  orderBy(order: String): Observable<any> {
    if(order === 'Ascending') {
      this.sortedInOrder = 'Asc';
    } else {
      this.sortedInOrder = 'Desc';
    }
    this.SORT_API = this.API + '/games/sortBy=' + this.sortedBy
      + '&' + this.sortedInOrder;
    return this.http.get(this.SORT_API);
  }

}
