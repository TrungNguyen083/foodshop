import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AutoIdService {
  private baseUrl = 'http://localhost:8080/api/getAutoGeneratedId';
  constructor(private http: HttpClient) { }

  getAutoGeneratedId(tableName: string, idName: string, word: string): Observable<string> {
    const params = new HttpParams()
      .set('tableName', tableName)
      .set('idName', idName)
      .set('word', word);

    return this.http.get(this.baseUrl, { params, responseType: 'text' });
  }
}
