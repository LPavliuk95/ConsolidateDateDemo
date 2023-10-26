import { LightningElement, track, wire, api } from 'lwc';
import getOrdersList from '@salesforce/apex/ConsolidateController.getWrapperClassList';

export default class OrderConsolidateData extends LightningElement {
    @api recordId;
    @track data = [];
    @wire(getList, {orderId: '$recordId'})
    
    wiredData(result) {

        if (result.data) {
            this.data = result.data;
        }
    }
    //
}
