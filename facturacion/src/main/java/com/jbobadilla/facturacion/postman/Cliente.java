{
	"info": {
		"_postman_id": "870904d6-276f-49da-b31f-195b344fd466",
		"name": "Crud facturación",
		"description": "# 🚀 Facturación\n\nImplementación de endpoints que permite realizar operaciones CRUD en Springboot",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "24518506"
	},
	"item": [
		{
			"name": "agencia",
			"item": [
				{
					"name": "addAgencia",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									"pm.test(\"Successful POST request\", function () {",
									"    pm.expect(pm.response.code).to.be.oneOf([200, 201]);",
									"});",
									""
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\n  \"ruc\": \"12345678901\",\n  \"razonSocial\": \"Agencia Lima\",\n  \"status\": \"ACTIVO\"\n}\n{\n  \"ruc\": \"87454512158\",\n  \"razonSocial\": \"Nestle\",\n  \"status\": \"ACTIVO\"\n}\n\n{\n\t\"ruc\": \"1510243555\",\n    \"razonSocial\" : \"Gloria\",\n    \"status\" : \"ACTIVO\"\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{url_agencia}}/",
							"host": [
								"{{url_agencia}}"
							],
							"path": [
								""
							]
						},
						"description": "This is a POST request, submitting data to an API via the request body. This request submits JSON data, and the data is reflected in the response.\n\nA successful POST request typically returns a `200 OK` or `201 Created` response code."
					},
					"response": []
				},
				{
					"name": "allAgencia",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									"pm.test(\"Status code is 200\", function () {",
									"    pm.response.to.have.status(200);",
									"});"
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "GET",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{url_agencia}}",
							"host": [
								"{{url_agencia}}"
							]
						},
						"description": "This is a GET request and it is used to \"get\" data from an endpoint. There is no request body for a GET request, but you can use query parameters to help specify the resource you want data on (e.g., in this request, we have `id=1`).\n\nA successful GET response will have a `200 OK` status, and should include some kind of response body - for example, HTML web content or JSON data."
					},
					"response": []
				},
				{
					"name": "byId",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									"pm.test(\"Status code is 200\", function () {",
									"    pm.response.to.have.status(200);",
									"});"
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "{{url_agencia}}/id/1",
							"host": [
								"{{url_agencia}}"
							],
							"path": [
								"id",
								"1"
							]
						},
						"description": "This is a GET request and it is used to \"get\" data from an endpoint. There is no request body for a GET request, but you can use query parameters to help specify the resource you want data on (e.g., in this request, we have `id=1`).\n\nA successful GET response will have a `200 OK` status, and should include some kind of response body - for example, HTML web content or JSON data."
					},
					"response": []
				},
				{
					"name": "byRuc",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									"pm.test(\"Status code is 200\", function () {",
									"    pm.response.to.have.status(200);",
									"});"
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "{{url_agencia}}/ruc/12345678901",
							"host": [
								"{{url_agencia}}"
							],
							"path": [
								"ruc",
								"12345678901"
							]
						},
						"description": "This is a GET request and it is used to \"get\" data from an endpoint. There is no request body for a GET request, but you can use query parameters to help specify the resource you want data on (e.g., in this request, we have `id=1`).\n\nA successful GET response will have a `200 OK` status, and should include some kind of response body - for example, HTML web content or JSON data."
					},
					"response": []
				},
				{
					"name": "byEstado",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									"pm.test(\"Status code is 200\", function () {",
									"    pm.response.to.have.status(200);",
									"});"
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "{{url_agencia}}/status/INACTIVO",
							"host": [
								"{{url_agencia}}"
							],
							"path": [
								"status",
								"INACTIVO"
							]
						},
						"description": "This is a GET request and it is used to \"get\" data from an endpoint. There is no request body for a GET request, but you can use query parameters to help specify the resource you want data on (e.g., in this request, we have `id=1`).\n\nA successful GET response will have a `200 OK` status, and should include some kind of response body - for example, HTML web content or JSON data."
					},
					"response": []
				},
				{
					"name": "changeEstado",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									"pm.test(\"Status code is 200\", function () {",
									"    pm.response.to.have.status(200);",
									"});"
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "PATCH",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n  \"status\": \"INACTIVO\"\r\n}\r\n",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{url_agencia}}/2/status",
							"host": [
								"{{url_agencia}}"
							],
							"path": [
								"2",
								"status"
							]
						},
						"description": "This is a GET request and it is used to \"get\" data from an endpoint. There is no request body for a GET request, but you can use query parameters to help specify the resource you want data on (e.g., in this request, we have `id=1`).\n\nA successful GET response will have a `200 OK` status, and should include some kind of response body - for example, HTML web content or JSON data."
					},
					"response": []
				},
				{
					"name": "Update data",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									"pm.test(\"Successful PUT request\", function () {",
									"    pm.expect(pm.response.code).to.be.oneOf([200, 201, 204]);",
									"});",
									""
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "PUT",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\n  \"ruc\": \"12345678901\",\n  \"razonSocial\": \"Agencia Lima Actualizada\",\n  \"status\": \"ACTIVO\"\n}\n",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{url_agencia}}/5",
							"host": [
								"{{url_agencia}}"
							],
							"path": [
								"5"
							]
						},
						"description": "This is a PUT request and it is used to overwrite an existing piece of data. For instance, after you create an entity with a POST request, you may want to modify that later. You can do that using a PUT request. You typically identify the entity being updated by including an identifier in the URL (eg. `id=1`).\n\nA successful PUT request typically returns a `200 OK`, `201 Created`, or `204 No Content` response code."
					},
					"response": []
				},
				{
					"name": "delete agencia",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									"pm.test(\"Successful DELETE request\", function () {",
									"    pm.expect(pm.response.code).to.be.oneOf([200, 202, 204]);",
									"});",
									""
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "DELETE",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{url_agencia}}/4",
							"host": [
								"{{url_agencia}}"
							],
							"path": [
								"4"
							]
						},
						"description": "This is a DELETE request, and it is used to delete data that was previously created via a POST request. You typically identify the entity being updated by including an identifier in the URL (eg. `id=1`).\n\nA successful DELETE request typically returns a `200 OK`, `202 Accepted`, or `204 No Content` response code."
					},
					"response": []
				}
			]
		},
		{
			"name": "cliente",
			"item": [
				{
					"name": "addCliente",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "\r\n{\r\n    \"dni\" : \"15421678\",\r\n    \"nombre\" : \"Pedro\",\r\n    \"apellido\" : \"Infante\"\r\n}\r\n\r\n{\r\n    \"dni\" : \"87451236\",\r\n    \"nombre\" : \"Carlos\",\r\n    \"apellido\" : \"Villalobos\"\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{url_cliente}}/",
							"host": [
								"{{url_cliente}}"
							],
							"path": [
								""
							]
						}
					},
					"response": []
				},
				{
					"name": "byId",
					"protocolProfileBehavior": {
						"disableBodyPruning": true
					},
					"request": {
						"method": "GET",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{url_cliente}}/id/1",
							"host": [
								"{{url_cliente}}"
							],
							"path": [
								"id",
								"1"
							]
						}
					},
					"response": []
				},
				{
					"name": "allClientes",
					"protocolProfileBehavior": {
						"disableBodyPruning": true
					},
					"request": {
						"method": "GET",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{url_cliente}}/",
							"host": [
								"{{url_cliente}}"
							],
							"path": [
								""
							]
						}
					},
					"response": []
				},
				{
					"name": "byDni",
					"protocolProfileBehavior": {
						"disableBodyPruning": true
					},
					"request": {
						"method": "GET",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{url_cliente}}/dni/15421678",
							"host": [
								"{{url_cliente}}"
							],
							"path": [
								"dni",
								"15421678"
							]
						}
					},
					"response": []
				},
				{
					"name": "updateCliente",
					"request": {
						"method": "PUT",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "\r\n{\r\n    \"dni\" : \"87451236\",\r\n    \"nombre\" : \"Carlos E.\",\r\n    \"apellido\" : \"Villalobos\"\r\n}\r\n",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{url_cliente}}/2",
							"host": [
								"{{url_cliente}}"
							],
							"path": [
								"2"
							]
						}
					},
					"response": []
				},
				{
					"name": "deleteCliente",
					"request": {
						"method": "DELETE",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "\r\n{\r\n    \"dni\" : \"87451236\",\r\n    \"nombre\" : \"Carlos E.\",\r\n    \"apellido\" : \"Villalobos\"\r\n}\r\n",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{url_cliente}}/1",
							"host": [
								"{{url_cliente}}"
							],
							"path": [
								"1"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "factura",
			"item": [
				{
					"name": "addFactura",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"nroFactura\": \"F001-125\",\r\n    \"fechaFactura\": \"2025-05-15\",\r\n    \"monto\" : 1500,\r\n    \"cliente\" : {\r\n        \"id\" : 1\r\n    },\r\n    \"agencia\" : {\r\n        \"id\" : 3\r\n    }\r\n\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{url_factura}}/",
							"host": [
								"{{url_factura}}"
							],
							"path": [
								""
							]
						}
					},
					"response": []
				},
				{
					"name": "byId",
					"protocolProfileBehavior": {
						"disableBodyPruning": true
					},
					"request": {
						"method": "GET",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"nroFactura\": \"F001-125\",\r\n    \"fechaFactura\": \"2025-05-15\",\r\n    \"monto\" : 1500,\r\n    \"cliente\" : {\r\n        \"id\" : 1\r\n    },\r\n    \"agencia\" : {\r\n        \"id\" : 3\r\n    }\r\n\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{url_factura}}/id/1",
							"host": [
								"{{url_factura}}"
							],
							"path": [
								"id",
								"1"
							]
						}
					},
					"response": []
				},
				{
					"name": "getAll",
					"protocolProfileBehavior": {
						"disableBodyPruning": true
					},
					"request": {
						"method": "GET",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"nroFactura\": \"F001-125\",\r\n    \"fechaFactura\": \"2025-05-15\",\r\n    \"monto\" : 1500,\r\n    \"cliente\" : {\r\n        \"id\" : 1\r\n    },\r\n    \"agencia\" : {\r\n        \"id\" : 3\r\n    }\r\n\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{url_factura}}/",
							"host": [
								"{{url_factura}}"
							],
							"path": [
								""
							]
						}
					},
					"response": []
				},
				{
					"name": "byNroFactura",
					"protocolProfileBehavior": {
						"disableBodyPruning": true
					},
					"request": {
						"method": "GET",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"nroFactura\": \"F001-125\",\r\n    \"fechaFactura\": \"2025-05-15\",\r\n    \"monto\" : 1500,\r\n    \"cliente\" : {\r\n        \"id\" : 1\r\n    },\r\n    \"agencia\" : {\r\n        \"id\" : 3\r\n    }\r\n\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{url_factura}}/nro-fact/F001-125",
							"host": [
								"{{url_factura}}"
							],
							"path": [
								"nro-fact",
								"F001-125"
							]
						}
					},
					"response": []
				},
				{
					"name": "updateFactura",
					"request": {
						"method": "PUT",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"nroFactura\": \"F001-125\",\r\n    \"fechaFactura\": \"2025-05-15\",\r\n    \"monto\" : 1350\r\n\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{url_factura}}/2",
							"host": [
								"{{url_factura}}"
							],
							"path": [
								"2"
							]
						}
					},
					"response": []
				},
				{
					"name": "deleteFactura",
					"request": {
						"method": "DELETE",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"nroFactura\": \"F001-125\",\r\n    \"fechaFactura\": \"2025-05-15\",\r\n    \"monto\" : 1350\r\n\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{url_factura}}/2",
							"host": [
								"{{url_factura}}"
							],
							"path": [
								"2"
							]
						}
					},
					"response": []
				}
			]
		}
	],
	"event": [
		{
			"listen": "prerequest",
			"script": {
				"type": "text/javascript",
				"exec": [
					""
				]
			}
		},
		{
			"listen": "test",
			"script": {
				"type": "text/javascript",
				"exec": [
					""
				]
			}
		}
	],
	"variable": [
		{
			"key": "id",
			"value": "1"
		},
		{
			"key": "base_url",
			"value": "http://localhost:8080/api"
		},
		{
			"key": "url_agencia",
			"value": "http://localhost:8080/api/agencia",
			"type": "string"
		},
		{
			"key": "url_cliente",
			"value": "http://localhost:8080/api/cliente",
			"type": "string"
		},
		{
			"key": "url_factura",
			"value": "http://localhost:8080/api/factura",
			"type": "string"
		}
	]
}