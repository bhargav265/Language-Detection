<style>
{% include blogspots.css %}
</style>
## Team
Nikhil Thakur - MS CS  - 804946345<br />
Akshay Sharma - MS CS  - 504946035<br />
Bhargav Parsi - MS CS  - 804945591<br />
Shraddha Manchekar - MS CS  - 004945217<br />

## Abstract
In natural language processing, language identification or language guessing is the problem of determining the language of the given content.
There are several statistical approaches to language identification using different techniques to classify the data.

## Introduction
In this project we have implemented 2 approaches to language identification. The first approach uses N-grams and the second uses deep neural network.
The first approach has been implemented in Java and the second in Python. 


## N-gram Model
An n-gram is a contiguous sequence of n items from a given sequence of text or speech. It is an N-character slice of a longer string. Typically, the string is sliced into a set of overlapping N-grams.

Given a novel document to be classified, the system computes the N-gram profile of this document (document profile) and compares the distance between this document profile and
the language profiles for all the supported languages. The language profile is basically the top N of the list of bi-grams and tri-grams sorted by frequency. The top 300 or so N-grams are almost always highly correlated to the language. Thus, the language profile of a sporty document will be very similar to the language profile generated from a political document in the same language. This gives us confidence that if we train the system on the Declaration of Human Right we will still be able to classify documents to the correct language even though they might have completely different topics. Starting at around rank 300 or so, an N-gram frequency profile begins to become specific to the topic. For the training and testing we took the data from <a target="_blank" href = "http://www.statmt.org/europarl/">European Parliament Proceeding Parallel Corpus</a>. The dataset contains text data for 21 european languages.



Given below are the top 50 most frequent combination of bigrams and trigrams for english language that we found from the training corpus.


<strong>[of the, in the, to the, the european, on the, it is, the commission, that the, and the, for the, to be, ' s, with the, by the, european union, we are, like to, the european union, that we, is a, we have, member states, the council, in this, this is, i would, at the, is the, will be, is not, of this, i am, from the, there is, that is, of a, has been, of the european, which is, as a, would like, must be, do not, have been, we must, and i, should be, would like to, that it, european parliament]<strong>
</strong>



To reduce the computation we computed the language profile for each language and serialized each one of them. Then, while testing we directly used them after deserializing.
For preprocessing the text, tokenization etc. we used the <a target="_blank" href = "https://stanfordnlp.github.io/CoreNLP/">Stanford CoreNlp library </a>. 

You can find the full Java code on the Github page. Feel free to use your choice of parameters for generating the language profiles.
Awesome, if you could increase the accuracy!!!!.



## Deep Neural Network Model


### Architecture of the Neural Network
From the previous Section, we see that the model gets 132 features. Recalling that there are 1400000 training examples and 350000 testing examples, we input the training examples into the Deep NN. We used Keras with Tensorflow to achieve this task. <br />
After every layer we add a dropout which is a simple technique used to prevent overfitting.
1. The first Layer has 132 input nodes connected with 500 hidden layer nodes.
2. Next we insert 300 hidden layer nodes.
3. After that, another 100 hidden layer nodes.
4. At last, We put 7 output layer nodes for each of the 7 classes. 

<img src="Images/architecture.PNG" width="500" align="middle">{: .center-image }
<center><b>Architecture using model.summary()</b></center>
<br>


### Results of DNN





## Results

The N-grams approach achieved an average accuracy of ~85% for the test set. It was observed that our prediction model misclassified appreciable amount of sentences for which the length was less. It couldn't find a match in the language profile and made a mistake.

The deep neural network achieved an accuracy of 99%. This shows the exceptional capability of Deep learning. Just by adding 3-4 dense layers remarkable results were obtained.
But of course, you have to take care of other factors too, viz overfitting, train-test split etc...



## Conclusion

By comparing the two approaches, we conclude that deep neural network surpasses the N-gram approach for language detection in almost all aspects. With a decent GPU you could train the net in a short time and see the magic it does.

For the N-gram approach, including the unigrams in the language profile too may help in correctly classifying even the short sentences in the data.



## References

1. Gyawali, Binod, Gabriela Ramírez-de-la-Rosa, and Thamar Solorio. "Native Language Identification: a Simple n-gram Based Approach." BEA@ NAACL-HLT. 2013.
2. Carlos Ramisch. “N-gram models for language detection.”
3. http://cloudmark.github.io/Language-Detection/
4. Kadri, Said, and Abdelouahab Moussaoui. "An effective method to recognize the language of a text in a collection of multilingual documents." Electronics, Computer and     	   Computation (ICECCO), 2013 International Conference on. IEEE, 2013.
5. 


