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
    
    wiredMaterialRequests({ error, data }) {
        if (data) {
            this.materialRequests = data;
        } else if (error) {
            console.error('Error loading material requests:', error);
        }
    }

    handleMaterialRequestCreated(event) {
        // Handle material request creation, e.g., refresh the list of material requests. TEst
       //
        this.refreshMaterialRequests();
    }

    refreshMaterialRequests() {
        // You can implement a method to refresh the list of material requests when a new one is created.
        refreshMaterialRequests({ workOrderId: this.recordId })
            .then((result) => {
                this.materialRequests = result;
            })
            .catch((error) => {
                console.error('Error refreshing material requests:', error);
            });
    }
    //
}


