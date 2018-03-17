import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class PlatformService {

  private API = '//localhost:8080';
  private PLATFORM_API = this.API + '/platforms';

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get
  }

}
