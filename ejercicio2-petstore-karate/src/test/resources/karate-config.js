function fn() {
  var env = karate.env || 'qa';
  karate.log('Ambiente de ejecución:', env);

  var config = {
    env: env,
    baseUrl: 'https://petstore.swagger.io/v2'
  };

  karate.configure('connectTimeout', 10000);
  karate.configure('readTimeout', 15000);
  karate.configure('logPrettyRequest', true);
  karate.configure('logPrettyResponse', true);
  karate.configure('retry', { count: 10, interval: 1500 });

  return config;
}
