<template>
  <div class="wrapper">
    <text class="title">todos</text>
    <image class="container" src="local:///content_bg"></image>    
    <div class="container">
      <div class="content">
        <image class="select-all" :src="this.selectres" @click="selectall"></image>
        <input class="input" placeholder="What needs to be done?" @change="onchange"/>
      </div>
      <list class="list">
        <cell class="cell" v-for="item in lists">
          <div class="cell-div" @click="clickitem(item)">
            <image class="cell-img" :src="item.checkres"></image>
            <text :class="[item.state]">{{item.title}}</text>
          </div>
        </cell>
      </list>
      <div class="bottom-bar">
        <text class="bottom-left">{{this.summ}}</text>
        <text class="bottom-unselect", @click="filterType('All')">All</text>
        <text class="bottom-unselect", @click="filterType('Active')">Active</text>
        <text class="bottom-unselect", @click="filterType('Completed')">Completed</text>
      </div>
    </div>
    
  </div>
</template>

<script>
  const modal = weex.requireModule('modal')
  export default {
    data: {
      summ: "",
      filter: "All",
      filterall: "bottom-select",
      filteractive: "bottom-unselect",
      filtercomplete: "bottom-unselect",
      noactive: false,
      selectres: "local:///down_arrow_disable",
      listsall:[],
      lists: [
      ],
    },
    methods: {
      onchange (event) {
        this.listsall.unshift({state: "active", title: event.value, checkres: "local:///item_select_default"})
        this.summary()
      },
      clickitem (data) {
        if (data.state == "complete") {
          data.state = "active"
          data.checkres = "local:///item_select_default"
        } else {
          data.state = "complete"
          data.checkres = "local:///item_select_bg"
        }
        this.summary()
      },
      summary () {
        var count = 0
        for (var i = 0; i < this.listsall.length; i++) {
          var item = this.listsall[i]
          if (item.state == "active") {
            count++
          }
        }
        this.summ = count + " items left"

        if (this.filter == "All") {
          this.lists = this.listsall.slice();
        } else if (this.filter == "Active") {
          this.lists = []
          for (var i = 0; i < this.listsall.length; i++) {
            var item = this.listsall[i]
            if (item.state == "active") {
              this.lists.push(item)
            }
          }
        } else {
          this.lists = []
          for (var i = 0; i < this.listsall.length; i++) {
            var item = this.listsall[i]
            if (item.state == "complete") {
              this.lists.push(item)
            }
          }
        }
      },
      filterType (typename) {
        this.filter = typename
        this.summary()
      },
      getTypeStyle (typename) {
        if (typename == this.filter) {
          return 'bottom-select'
        } else {
          return 'bottom-unselect'
        }
      },
      selectall () {
        if (this.noactive) {
          this.noactive = false
          this.selectres = "local:///down_arrow_disable"
        } else {
          this.noactive = true
          this.selectres = "local:///down_arrow"
        }

        for (var i = 0; i < this.listsall.length; i++) {
          var item = this.listsall[i]
          item.state = this.noactive ? "complete" : "active"
          item.checkres = this.noactive ? "local:///item_select_bg" : "local:///item_select_default"
        }

        this.summary()
      }
    }
  }
</script>

<style>
  .wrapper { 
    align-items: center; 
  }
  .container {
    position: absolute;
    top: 300;
    right: 0;
    bottom: 50;
    left: 0;
  }
  .content {
    flex-direction: row;
    align-items: center;
    border-width: 2;
    border-style: solid;
    border-color: #BBB;
    margin-left: 50;
    margin-right: 50;
    margin-top: 20;
    padding-left: 10;
    padding-right: 10;
  }
  .title { 
    font-size: 160;
    color: rgba(175,47,47,0.15); 
    margin-top: 100;
  }
  .select-all { 
    width: 70; 
    height: 60; 
    padding: 20;
    text-align: center;
  }
  .input {
    flex: 1;
    height: 100;
    font-size: 40;
    margin-left: 20;
    placeholder-color: #e6e6e6;
  }
  .list {
    height: 400;
    margin-left: 50;
    margin-right: 50;
  }
  .cell-div {
    height: 100;
    flex-direction: row;
    align-items: center;
    padding-left: 8;
    padding-right: 8;
    border-width: 2;
    border-style: solid;
    border-left-color: #f0f0f0;
    border-top-color: #f0f0f0;
    border-right-color: #f0f0f0;    
    border-bottom-color: #CCC;
  }
  .cell-img {
    width: 60;
    height: 60;
  }
  .bottom-bar {
    height: 100;
    padding: 20;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    margin-left: 50;
    margin-right: 50;
  }
  .active {
    width: 400;
    font-size: 40;
    color: #4d4d4d;
    margin-left: 20;
  }
  .complete {
    width: 400;
    font-size: 40;
    color: #d9d9d9;
    margin-left: 20;
    text-decoration: line-through;
  }
  .bottom-select {
    font-size: 20;
    border-width: 2;
    border-style: solid;
    border-color: rgba(175,47,47,0.15);
    padding: 16;
  }
  .bottom-unselect {
    font-size: 20;
    padding: 18
  }
</style>