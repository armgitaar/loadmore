<template>
    <div class="ShowMore">
      <li v-for="image in images" class="p-4 bg-white rounded-lg mb-3 flex flex-st">
        <div class="flex">
          <div class="self-center">
              <a href="{{ image.src }}" target="_blank">
                <img class="h-20 w-20 object-cover rounded-lg" src="{{ image.src }}">
              </a>
          </div>
          <div class="ml-6 pr-4 flex-1">
            <div class="text-xl font-bold text-gray-900"> {{ image.name }} </div>
          </div>
        </div>
      </li>

      <div id="load_more">
        <button @click="showMore" type="button" name="show_more_button" class="font-semibold uppercase py-2 px-4 rounded-lg inline-flex" data-id="5" id="show_more_button">
          <svg class="fill-current h-4 w-4 mr-2 mt-1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"><path d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z"/></svg>
          {{ buttonText }}
        </button>
      </div>
    </div>
</template>

<script>
    export default {

        name: "ShowMore",

        data() {
          return {
            images: [],
            buttonText: 'Show More',
            id: 5
           }
        },

        methods: {
            showMore() {
                this.buttonText = 'Loading more images...',

                axios.post('/vuemore', {id:this.id} ).then(response => {
                   var newData = [];

                   if(response.data != '' ){
                      for (let i = 0; i < response.data.length; i++){
                         newData.push(response.data[i]);
                      }
                   } else {

                      $('#show_more_button').remove();

                   }
                   this.images = this.images.concat(newData);
                   this.id += 5;
                });
                this.buttonText = 'Show More'
            }
         }
    };
</script>
