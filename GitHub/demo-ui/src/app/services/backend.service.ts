import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { DemoDTO } from '../interfaces/demo-dto';

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  constructor(private http: HttpClient) { }

  /*
    -->
    GET Method(s)
    <--
  */

  /**
   * GET ALL DATA SAVED IN DEMO-TABLE (DB)
   */
  public get(): Promise<any> {
    return this.http.get<DemoDTO[]>(`${environment.serviceHost}all`).toPromise();
  }



  /*
    -->
    PUT Method(s)
    <--
  */

  /**
   * UPDATE ITEM IN DEMO-TABLE (DB)
   *
   * @param demo Object to be updated (ID required!)
   */
  public put(demo: DemoDTO): Promise<DemoDTO> {
    return this.http.put<DemoDTO>(`${environment.serviceHost}update`, demo).toPromise();
  }



 /*
    -->
    POST Method(s)
    <--
  */

  /**
   * SAVE NEW OBJECT IN DEMO-TABLE (DB)
   *
   * @param demo Object to be saved (Do not set ID! -> auto generated)
   */
  public post(demo: DemoDTO): Promise<DemoDTO> {
    return this.http.post<DemoDTO>(`${environment.serviceHost}create`, demo).toPromise();
  }


}
