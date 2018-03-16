import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class GameService {
  private API = '//localhost:8080';
  private GAME_API = this.API + '/games';

  constructor(private http: HttpClient) {

  }

  getAll(): Observable<any> {
    return this.http.get(this.GAME_API);
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

}
