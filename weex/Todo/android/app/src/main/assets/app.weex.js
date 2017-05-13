// { "framework": "Vue" }

/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};

/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {

/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId])
/******/ 			return installedModules[moduleId].exports;

/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			exports: {},
/******/ 			id: moduleId,
/******/ 			loaded: false
/******/ 		};

/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);

/******/ 		// Flag the module as loaded
/******/ 		module.loaded = true;

/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}


/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;

/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;

/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";

/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(0);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ (function(module, exports, __webpack_require__) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _foo = __webpack_require__(1);

	var _foo2 = _interopRequireDefault(_foo);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	_foo2.default.el = '#root';
	exports.default = new Vue(_foo2.default);

/***/ }),
/* 1 */
/***/ (function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = []

	/* styles */
	__vue_styles__.push(__webpack_require__(2)
	)

	/* script */
	__vue_exports__ = __webpack_require__(3)

	/* template */
	var __vue_template__ = __webpack_require__(4)
	__vue_options__ = __vue_exports__ = __vue_exports__ || {}
	if (
	  typeof __vue_exports__.default === "object" ||
	  typeof __vue_exports__.default === "function"
	) {
	if (Object.keys(__vue_exports__).some(function (key) { return key !== "default" && key !== "__esModule" })) {console.error("named exports are not supported in *.vue files.")}
	__vue_options__ = __vue_exports__ = __vue_exports__.default
	}
	if (typeof __vue_options__ === "function") {
	  __vue_options__ = __vue_options__.options
	}
	__vue_options__.__file = "/Users/xf/Documents/git_space/TodoPractice/weex/Todo/src/foo.vue"
	__vue_options__.render = __vue_template__.render
	__vue_options__.staticRenderFns = __vue_template__.staticRenderFns
	__vue_options__._scopeId = "data-v-68ada9d8"
	__vue_options__.style = __vue_options__.style || {}
	__vue_styles__.forEach(function (module) {
	  for (var name in module) {
	    __vue_options__.style[name] = module[name]
	  }
	})
	if (typeof __register_static_styles__ === "function") {
	  __register_static_styles__(__vue_options__._scopeId, __vue_styles__)
	}

	module.exports = __vue_exports__


/***/ }),
/* 2 */
/***/ (function(module, exports) {

	module.exports = {
	  "wrapper": {
	    "alignItems": "center"
	  },
	  "container": {
	    "position": "absolute",
	    "top": 300,
	    "right": 0,
	    "bottom": 50,
	    "left": 0
	  },
	  "content": {
	    "flexDirection": "row",
	    "alignItems": "center",
	    "borderWidth": 2,
	    "borderStyle": "solid",
	    "borderColor": "#BBBBBB",
	    "marginLeft": 50,
	    "marginRight": 50,
	    "marginTop": 20,
	    "paddingLeft": 10,
	    "paddingRight": 10
	  },
	  "title": {
	    "fontSize": 160,
	    "color": "rgba(175,47,47,0.15)",
	    "marginTop": 100
	  },
	  "select-all": {
	    "width": 70,
	    "height": 60,
	    "padding": 20,
	    "textAlign": "center"
	  },
	  "input": {
	    "flex": 1,
	    "height": 100,
	    "fontSize": 40,
	    "marginLeft": 20,
	    "placeholderColor": "#e6e6e6"
	  },
	  "list": {
	    "height": 400,
	    "marginLeft": 50,
	    "marginRight": 50
	  },
	  "cell-div": {
	    "height": 100,
	    "flexDirection": "row",
	    "alignItems": "center",
	    "paddingLeft": 8,
	    "paddingRight": 8,
	    "borderWidth": 2,
	    "borderStyle": "solid",
	    "borderLeftColor": "#f0f0f0",
	    "borderTopColor": "#f0f0f0",
	    "borderRightColor": "#f0f0f0",
	    "borderBottomColor": "#CCCCCC"
	  },
	  "cell-img": {
	    "width": 60,
	    "height": 60
	  },
	  "bottom-bar": {
	    "height": 100,
	    "padding": 20,
	    "flexDirection": "row",
	    "justifyContent": "space-between",
	    "alignItems": "center",
	    "marginLeft": 50,
	    "marginRight": 50
	  },
	  "active": {
	    "width": 400,
	    "fontSize": 40,
	    "color": "#4d4d4d",
	    "marginLeft": 20
	  },
	  "complete": {
	    "width": 400,
	    "fontSize": 40,
	    "color": "#d9d9d9",
	    "marginLeft": 20,
	    "textDecoration": "line-through"
	  },
	  "bottom-select": {
	    "fontSize": 20,
	    "borderWidth": 2,
	    "borderStyle": "solid",
	    "borderColor": "rgba(175,47,47,0.15)",
	    "padding": 16
	  },
	  "bottom-unselect": {
	    "fontSize": 20,
	    "padding": 18
	  }
	}

/***/ }),
/* 3 */
/***/ (function(module, exports) {

	"use strict";

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//

	var modal = weex.requireModule('modal');
	exports.default = {
	  data: {
	    summ: "",
	    filter: "All",
	    filterall: "bottom-select",
	    filteractive: "bottom-unselect",
	    filtercomplete: "bottom-unselect",
	    noactive: false,
	    selectres: "local:///down_arrow_disable",
	    listsall: [],
	    lists: []
	  },
	  methods: {
	    onchange: function onchange(event) {
	      this.listsall.unshift({ state: "active", title: event.value, checkres: "local:///item_select_default" });
	      this.summary();
	    },
	    clickitem: function clickitem(data) {
	      if (data.state == "complete") {
	        data.state = "active";
	        data.checkres = "local:///item_select_default";
	      } else {
	        data.state = "complete";
	        data.checkres = "local:///item_select_bg";
	      }
	      this.summary();
	    },
	    summary: function summary() {
	      var count = 0;
	      for (var i = 0; i < this.listsall.length; i++) {
	        var item = this.listsall[i];
	        if (item.state == "active") {
	          count++;
	        }
	      }
	      this.summ = count + " items left";

	      if (this.filter == "All") {
	        this.lists = this.listsall.slice();
	      } else if (this.filter == "Active") {
	        this.lists = [];
	        for (var i = 0; i < this.listsall.length; i++) {
	          var item = this.listsall[i];
	          if (item.state == "active") {
	            this.lists.push(item);
	          }
	        }
	      } else {
	        this.lists = [];
	        for (var i = 0; i < this.listsall.length; i++) {
	          var item = this.listsall[i];
	          if (item.state == "complete") {
	            this.lists.push(item);
	          }
	        }
	      }
	    },
	    filterType: function filterType(typename) {
	      this.filter = typename;
	      this.summary();
	    },
	    getTypeStyle: function getTypeStyle(typename) {
	      if (typename == this.filter) {
	        return 'bottom-select';
	      } else {
	        return 'bottom-unselect';
	      }
	    },
	    selectall: function selectall() {
	      if (this.noactive) {
	        this.noactive = false;
	        this.selectres = "local:///down_arrow_disable";
	      } else {
	        this.noactive = true;
	        this.selectres = "local:///down_arrow";
	      }

	      for (var i = 0; i < this.listsall.length; i++) {
	        var item = this.listsall[i];
	        item.state = this.noactive ? "complete" : "active";
	        item.checkres = this.noactive ? "local:///item_select_bg" : "local:///item_select_default";
	      }

	      this.summary();
	    }
	  }
	};

/***/ }),
/* 4 */
/***/ (function(module, exports) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
	  return _c('div', {
	    staticClass: ["wrapper"]
	  }, [_c('text', {
	    staticClass: ["title"]
	  }, [_vm._v("todos")]), _c('image', {
	    staticClass: ["container"],
	    attrs: {
	      "src": "local:///content_bg"
	    }
	  }), _c('div', {
	    staticClass: ["container"]
	  }, [_c('div', {
	    staticClass: ["content"]
	  }, [_c('image', {
	    staticClass: ["select-all"],
	    attrs: {
	      "src": this.selectres
	    },
	    on: {
	      "click": _vm.selectall
	    }
	  }), _c('input', {
	    staticClass: ["input"],
	    attrs: {
	      "placeholder": "What needs to be done?"
	    },
	    on: {
	      "change": _vm.onchange
	    }
	  })]), _c('list', {
	    staticClass: ["list"]
	  }, _vm._l((_vm.lists), function(item) {
	    return _c('cell', {
	      staticClass: ["cell"],
	      appendAsTree: true,
	      attrs: {
	        "append": "tree"
	      }
	    }, [_c('div', {
	      staticClass: ["cell-div"],
	      on: {
	        "click": function($event) {
	          _vm.clickitem(item)
	        }
	      }
	    }, [_c('image', {
	      staticClass: ["cell-img"],
	      attrs: {
	        "src": item.checkres
	      }
	    }), _c('text', {
	      class: [item.state]
	    }, [_vm._v(_vm._s(item.title))])])])
	  })), _c('div', {
	    staticClass: ["bottom-bar"]
	  }, [_c('text', {
	    staticClass: ["bottom-left"]
	  }, [_vm._v(_vm._s(this.summ))]), _c('text', {
	    staticClass: ["bottom-unselect"],
	    attrs: {
	      ",": ""
	    },
	    on: {
	      "click": function($event) {
	        _vm.filterType('All')
	      }
	    }
	  }, [_vm._v("All")]), _c('text', {
	    staticClass: ["bottom-unselect"],
	    attrs: {
	      ",": ""
	    },
	    on: {
	      "click": function($event) {
	        _vm.filterType('Active')
	      }
	    }
	  }, [_vm._v("Active")]), _c('text', {
	    staticClass: ["bottom-unselect"],
	    attrs: {
	      ",": ""
	    },
	    on: {
	      "click": function($event) {
	        _vm.filterType('Completed')
	      }
	    }
	  }, [_vm._v("Completed")])])])])
	},staticRenderFns: []}
	module.exports.render._withStripped = true

/***/ })
/******/ ]);